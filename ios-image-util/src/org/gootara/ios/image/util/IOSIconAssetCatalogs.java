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

/**
 * @author gootara.org
 *
 */
public enum IOSIconAssetCatalogs implements IOSAssetCatalogs {
	IPHONE_29  (IOS6IconInfo.ICON_29   , IOSAssetCatalogs.iPhone),
	IPHONE_29x2(IOS6IconInfo.ICON_29x2 , IOSAssetCatalogs.iPhone),
	IPHONE_40x2(IOS7IconInfo.ICON_40x2 , IOSAssetCatalogs.iPhone),
	IPHONE_57  (IOS6IconInfo.ICON_57   , IOSAssetCatalogs.iPhone),
	IPHONE_57x2(IOS6IconInfo.ICON_57x2 , IOSAssetCatalogs.iPhone),
	IPHONE_60x2(IOS7IconInfo.ICON_60x2 , IOSAssetCatalogs.iPhone),
	IPAD_29  (IOS6IconInfo.ICON_29   , IOSAssetCatalogs.iPad),
	IPAD_29x2(IOS6IconInfo.ICON_29x2 , IOSAssetCatalogs.iPad),
	IPAD_40  (IOS7IconInfo.ICON_40   , IOSAssetCatalogs.iPad),
	IPAD_40x2(IOS7IconInfo.ICON_40x2 , IOSAssetCatalogs.iPad),
	IPAD_50  (IOS6IconInfo.ICON_50   , IOSAssetCatalogs.iPad),
	IPAD_50x2(IOS6IconInfo.ICON_50x2 , IOSAssetCatalogs.iPad),
	IPAD_72  (IOS6IconInfo.ICON_72   , IOSAssetCatalogs.iPad),
	IPAD_72x2(IOS6IconInfo.ICON_72x2 , IOSAssetCatalogs.iPad),
	IPAD_76  (IOS7IconInfo.ICON_76   , IOSAssetCatalogs.iPad),
	IPAD_76x2(IOS7IconInfo.ICON_76x2 , IOSAssetCatalogs.iPad),
	;

	private IOSImageInfo info;
	private String idiom;
	private IOSIconAssetCatalogs(IOSImageInfo info, String idiom) {
		this.info = info;
		this.idiom = idiom;
	}

	@Override public String getIdiom() { return this.idiom; }
	@Override public String getFilename() { return info.getFilename(); }
	@Override public String getScale() { return (info.isRetina() ? "2x" : "1x"); }
	@Override public boolean isIphone() { return this.getIdiom().equals(IOSAssetCatalogs.iPhone); }
	@Override public boolean isIpad() { return this.getIdiom().equals(IOSAssetCatalogs.iPad); }

	public String toJson() {
		StringBuilder sb = new StringBuilder("    {\n");
		sb.append(String.format("      \"size\" : \"%dx%d\",\n", info.getSize().width / (info.isRetina() ? 2 : 1), info.getSize().height / (info.isRetina() ? 2 : 1)));
		sb.append(String.format("      \"idiom\" : \"%s\",\n", this.getIdiom()));
		sb.append(String.format("      \"filename\" : \"%s\",\n", info.getFilename()));
		sb.append(String.format("      \"scale\" : \"%s\"\n", this.getScale()));
		sb.append("    }");
		return sb.toString();
	}

}
