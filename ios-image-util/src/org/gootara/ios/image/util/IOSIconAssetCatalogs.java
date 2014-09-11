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
 * The asset catalogs of icon for iOS.
 *
 * @author gootara.org
 * @see org.gootara.ios.image.util.IOSAssetCatalogs
 */
public enum IOSIconAssetCatalogs implements IOSAssetCatalogs {
	IPHONE_29   (IOSIconInfo.ICON_29   , iPhone , SYSTEM_VERSION_ANY),
	IPHONE_29x2 (IOSIconInfo.ICON_29x2 , iPhone , SYSTEM_VERSION_7),
	IPHONE_29x3 (IOSIconInfo.ICON_29x3 , iPhone , SYSTEM_VERSION_8),
	IPHONE_40x2 (IOSIconInfo.ICON_40x2 , iPhone , SYSTEM_VERSION_7),
	IPHONE_40x3 (IOSIconInfo.ICON_40x3 , iPhone , SYSTEM_VERSION_8),
	IPHONE_57   (IOSIconInfo.ICON_57   , iPhone , SYSTEM_VERSION_ANY),
	IPHONE_57x2 (IOSIconInfo.ICON_57x2 , iPhone , SYSTEM_VERSION_ANY),
	IPHONE_60x2 (IOSIconInfo.ICON_60x2 , iPhone , SYSTEM_VERSION_7),
	IPHONE_60x3 (IOSIconInfo.ICON_60x3 , iPhone , SYSTEM_VERSION_8),
	IPAD_29   (IOSIconInfo.ICON_29   , iPad , SYSTEM_VERSION_7),
	IPAD_29x2 (IOSIconInfo.ICON_29x2 , iPad , SYSTEM_VERSION_7),
	IPAD_40   (IOSIconInfo.ICON_40   , iPad , SYSTEM_VERSION_7),
	IPAD_40x2 (IOSIconInfo.ICON_40x2 , iPad , SYSTEM_VERSION_7),
	IPAD_50   (IOSIconInfo.ICON_50   , iPad , SYSTEM_VERSION_ANY),
	IPAD_50x2 (IOSIconInfo.ICON_50x2 , iPad , SYSTEM_VERSION_ANY),
	IPAD_72   (IOSIconInfo.ICON_72   , iPad , SYSTEM_VERSION_ANY),
	IPAD_72x2 (IOSIconInfo.ICON_72x2 , iPad , SYSTEM_VERSION_ANY),
	IPAD_76   (IOSIconInfo.ICON_76   , iPad , SYSTEM_VERSION_7),
	IPAD_76x2 (IOSIconInfo.ICON_76x2 , iPad , SYSTEM_VERSION_7),
	;

	private IOSImageInfo info;
	private String idiom;
	private float minimumSystemVersion;
	private IOSIconAssetCatalogs(IOSImageInfo info, String idiom, float minimumSystemVersion) {
		this.info = info;
		this.idiom = idiom;
		this.minimumSystemVersion = minimumSystemVersion;
	}

	@Override public IOSImageInfo getIOSImageInfo() { return this.info; }
	@Override public String getIdiom() { return this.idiom; }
	@Override public float getMinimumSystemVersion() { return this.minimumSystemVersion; }
	@Override public String getFilename() { return info.getFilename(); }
	@Override public String getScale() { return (String.format("%dx", info.getScale())); }
	@Override public boolean isIphone() { return this.getIdiom().equals(iPhone); }
	@Override public boolean isIpad() { return this.getIdiom().equals(iPad); }
	@Override public String toJson() {
		StringBuilder sb = new StringBuilder("    {\n");
		sb.append(String.format("      \"size\" : \"%dx%d\",\n", info.getSize().width / info.getScale(), info.getSize().height / info.getScale()));
		sb.append(String.format("      \"idiom\" : \"%s\",\n", this.getIdiom()));
		sb.append(String.format("      \"filename\" : \"%s\",\n", info.getFilename()));
		sb.append(String.format("      \"scale\" : \"%s\"\n", this.getScale()));
		sb.append("    }");
		return sb.toString();
	}

}
