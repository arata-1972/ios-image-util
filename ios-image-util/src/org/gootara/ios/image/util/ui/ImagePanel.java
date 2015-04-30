/**
 * Copyright (c) 2013 gootara.org <http://gootara.org>
 *
 * The MIT License (MIT)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package org.gootara.ios.image.util.ui;

import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.image.BufferedImage;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * @author gootara.org
 *
 */
public class ImagePanel extends JPanel {

	private java.io.File imageFile;
	private Image image, scaledImage;
	private String placeHolder, hyphenatorBoL, hyphnatorEoL;

	/**
	 * Constructor.
	 */
	public ImagePanel() {
		this("");
	}

	/**
	 * Constructor with the placeholder.
	 *
	 * @param placeHolder placeHolder
	 */
	public ImagePanel(String placeHolder) {
		this.image = null;
		this.scaledImage = null;
		this.setPlaceHolder(placeHolder);
		this.setHyphenator("", "");
		final Timer timer = new Timer(500, new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				createScaledImage();
				repaint();
			}
		});
		timer.setRepeats(false);
		this.addComponentListener(new ComponentListener() {
			@Override public void componentResized(ComponentEvent e) {
				if (timer.isRunning()) {
					timer.stop();
				}
				timer.start();
			}
			@Override public void componentMoved(ComponentEvent e) {}
			@Override public void componentShown(ComponentEvent e) {}
			@Override public void componentHidden(ComponentEvent e) {}
		});
	}

	/**
	 * Set image to display.
	 *
	 * @param image image
	 */
	public void setImage(BufferedImage image) {
		if (this.image != null) {
			this.image.flush();
			this.image = null;
		}

		Dimension size = new Dimension(image.getWidth(), image.getHeight());
		if (size.getWidth() > 1024d || size.getHeight() > 1024d) {
			size = new Dimension(1024, 1024);
		}
		this.image = this.createScaledImage(image, new Dimension(image.getWidth(), image.getHeight()), size);
		createScaledImage();
		this.repaint();
		this.modifyTooktip();
	}

	/**
	 * Get image.
	 *
	 * @return image
	 */
	public Image getImage(){
		return this.image;
	}

	@Override public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(!isShowing()){
			return;
		}
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		if (image == null || scaledImage == null) {
			// Maybe padding, border and text-align will be implemented in some future.(but not need currently)
			FontMetrics fm = this.getFontMetrics(this.getFont());
			ArrayList<String> lines = this.getPlaceHolderLines(fm);
			int y = (this.getHeight() / 2) - ((fm.getHeight() * lines.size()) / 2) + fm.getAscent();
			for (String line : lines) {
				int x = (this.getWidth() - fm.stringWidth(line)) / 2;
				g.setColor(this.getForeground());
				g.drawString(line, x, y);
				y += fm.getHeight();
			}

		} else {
			int x = (int) ((this.getWidth() - this.scaledImage.getWidth(this)) / 2);
			int y = (int) ((this.getHeight() - this.scaledImage.getHeight(this)) / 2);
			g.drawImage(scaledImage, x, y, this);
		}
		g.setColor(this.getForeground());
		g.drawRect(0,  0, this.getWidth() - 1, this.getHeight() - 1);
	}

	@Override public Dimension getPreferredSize() {
		if (image == null) {
			return (new Dimension(0, 0));
		}
		return (new Dimension(image.getWidth(this), image.getHeight(this)));
	}

	@Override public void update(Graphics g) {
		paint(g);
	}

	/**
	 * Get the placeholder.
	 *
	 * @return placeHolder
	 */
	public String getPlaceHolder() {
		return placeHolder;
	}

	/**
	 * Set the placeholder.
	 *
	 * @param placeHolder set placeHolder
	 */
	public void setPlaceHolder(String placeHolder) {
		this.placeHolder = placeHolder;
	}

	/**
	 * Get the placeholder which is divided by width and words.
	 *
	 * @param fm FontMetrics
	 * @return the placeholder which is divided by width and words.
	 */
	public ArrayList<String> getPlaceHolderLines(FontMetrics fm) {
		// Separate by line.
		ArrayList<String> lines = new ArrayList<String>();
		if (this.getPlaceHolder() == null || this.getPlaceHolder().isEmpty()) return lines;
		String[] text = this.getPlaceHolder().split("[\r\n]");
		for (String t : text) {
			if (t.trim().isEmpty()) {
				lines.add("");
			} else {
				lines.addAll(this.splitText(t, fm));
			}
		}
		return lines;
	}

	/**
	 * Split text into display lines.
	 *
	 * @param text	text for split
	 * @param fm	FontMetrics
	 * @return	splitted text into display lines
	 */
	private ArrayList<String> splitText(String text, FontMetrics fm) {
		ArrayList<String> lines = new ArrayList<String>();
		StringBuilder line = new StringBuilder();
		Locale l = Locale.getDefault();
		BreakIterator boundary = BreakIterator.getWordInstance(l.equals(Locale.JAPAN) || l.equals(Locale.JAPANESE) ? l : Locale.US);
		boundary.setText(text);
		int startIndex = boundary.first();
		for (int endIndex = boundary.next(); endIndex != BreakIterator.DONE; startIndex = endIndex, endIndex = boundary.next()) {
			String word = text.substring(startIndex, endIndex);
			if (fm.stringWidth(line.toString()) + fm.stringWidth(word) > this.getWidth()) {
				// Very easy hyphenation. (just only one character)
				if (this.hyphenatorBoL != null && word.length() == 1 && this.hyphenatorBoL.indexOf(word.charAt(0)) >= 0) {
					line.append(word);
					word = new String();
				} else if (this.hyphnatorEoL != null && line.length() > 1 && this.hyphnatorEoL.indexOf(line.charAt(line.length() - 1)) >= 0) {
					word = line.substring(line.length() - 1).concat(word);
					line.setLength(line.length() - 1);
				}
				if (line.toString().replace('\u3000', ' ').trim().length() > 0) {
					lines.add(line.toString());
				}
				line.setLength(0);
			}
			line.append(word);
		}
		if (line.toString().replace('\u3000', ' ').trim().length() > 0) {
			lines.add(line.toString());
		}
		return lines;
	}

	/**
	 * Create scaled image.
	 */
	private synchronized void createScaledImage() {
		if (this.scaledImage != null) {
			this.scaledImage.flush();
			this.scaledImage = null;
		}
		if (image == null) {
			return;
		}
		this.scaledImage = this.createScaledImage(this.image, this.getPreferredSize(), new Dimension(this.getWidth(), this.getHeight()));
	}
	private Image createScaledImage(Image src, Dimension preferredSize, Dimension maximumSize) {
		if (preferredSize.width <= 0 || preferredSize.height <= 0) return null;
		double p = (maximumSize.getWidth() > maximumSize.getHeight()) ? maximumSize.getHeight() / preferredSize.getHeight() : maximumSize.getWidth() / preferredSize.getWidth();
		if (preferredSize.width != preferredSize.height) {
			double p2 = (preferredSize.width < preferredSize.height) ? maximumSize.getHeight() / preferredSize.getHeight() : maximumSize.getWidth() / preferredSize.getWidth();
			if (p2 < p) { p = p2; }
		}
		int w = (int) (preferredSize.getWidth() * p);
		int h = (int) (preferredSize.getHeight() * p);
		if (w <= 0 || h <= 0) return null;
		return src.getScaledInstance(w, h, Image.SCALE_SMOOTH);
	}

	/**
	 * Clear images.
	 */
	public void clear() {
		if (this.image != null) {
			this.image.flush();
			this.image = null;
		}
		if (this.scaledImage != null) {
			this.scaledImage.flush();
			this.scaledImage = null;
		}
		this.imageFile = null;
		this.repaint();
		this.modifyTooktip();
	}

	/**
	 * Set hyphenator.
	 *
	 * @param beginingOfLine
	 * @param endOfLine
	 */
	public void setHyphenator(String beginingOfLine, String endOfLine) {
		this.hyphenatorBoL = beginingOfLine;
		this.hyphnatorEoL = endOfLine;
	}

	/**
	 * @return imageFile
	 */
	public java.io.File getImageFile() {
		return imageFile;
	}

	/**
	 * @param imageFile set imageFile
	 */
	public void setImageFile(java.io.File imageFile) {
		this.imageFile = imageFile;
	}

	private void modifyTooktip() {
		if (placeHolder == null || placeHolder.trim().length() <= 0) {
			this.setToolTipText(null);
			return;
		}
		this.setToolTipText(image == null || scaledImage == null ? null : placeHolder);
	}

}


