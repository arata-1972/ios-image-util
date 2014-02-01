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
package org.gootara.ios.image.util;

import java.awt.Dimension;

/**
 * @author gootara.org
 *
 */
public enum IOS6SplashInfo implements IOSImageInfo {
	// Move to IOS7SplashInfo.java
//	SPLASH_480("Default.png", 320, 480, "iPhone 3G / 3GS"),
//	SPLASH_480x2("Default@2x.png", 640, 960, "iPhone4 / 4S"),
//	SPLASH_568x2("Default-568h@2x.png", 640, 1136, "iPhone 5 or later"),
    //                   filename                    width   height  iPhone  iPad    retina   description
    SPLASH_PORTRAIT(    "Default-Portrait.png"     , 768   , 1004  , false , true  , false , "iPad / iPad2 / iPad mini"),
    SPLASH_PORTRAITx2(  "Default-Portrait@2x.png"  , 1536  , 2008  , false , true  , true  , "iPad 3 or later"),
    SPLASH_LANDSCAPE(   "Default-Landscape.png"    , 1024  , 748   , false , true  , false , "iPad / iPad2 / iPad mini"),
    SPLASH_LANDSCAPEx2( "Default-Landscape@2x.png" , 2048  , 1496  , false , true  , true  , "iPad 3 or later"),
	;

	private String filename;
	private Dimension size;
	private boolean iphoneImage;
	private boolean ipadImage;
	private boolean retina;
	private String description;
	private IOS6SplashInfo(String filename, int width, int height, boolean iphoneImage, boolean ipadImage, boolean retina, String description) {
		this.filename = filename;
		this.size = new Dimension(width, height);
		this.iphoneImage = iphoneImage;
		this.ipadImage = ipadImage;
		this.description = description;
		this.retina = retina;
	}
	@Override public String getFilename() { return this.filename; }
	@Override public Dimension getSize() { return this.size; }
	@Override public boolean isIphoneImage() { return this.iphoneImage; }
	@Override public boolean isIpadImage() { return this.ipadImage; }
	@Override public boolean isRetina() { return this.retina; }
	@Override public String getDescription() { return this.description; }
}
