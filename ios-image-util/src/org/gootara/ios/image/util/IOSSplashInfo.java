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
 * The informations of launch image for iOS.
 *
 * @author gootara.org
 * @see org.gootara.ios.image.util.IOSImageInfo
 */
public enum IOSSplashInfo implements IOSImageInfo {
    //                        filename                         width   height  scale      description
    SPLASH_480             ( "Default.png"                   , 320   , 480   , 1    ), // iPhone 3G / 3GS
    SPLASH_480x2           ( "Default@2x.png"                , 640   , 960   , 2    ), // iPhone4 / 4S
    SPLASH_568x2           ( "Default-568h@2x.png"           , 640   , 1136  , 2    ), // iPhone 5 or later
    SPLASH_PORTRAIT        ( "Default-Portrait~ipad.png"     , 768   , 1024  , 1    ), // iPad / iPad2 / iPad mini
    SPLASH_PORTRAITx2      ( "Default-Portrait@2x~ipad.png"  , 1536  , 2048  , 2    ), // iPad 3 or later
    SPLASH_LANDSCAPE       ( "Default-Landscape~ipad.png"    , 1024  , 768   , 1    ), // iPad / iPad2 / iPad mini
    SPLASH_LANDSCAPEx2     ( "Default-Landscape@2x~ipad.png" , 2048  , 1536  , 2    ), // iPad 3 or later
    SPLASH_PORTRAIT_STB    ( "Default-Portrait.png"          , 768   , 1004  , 1    ), // iPad / iPad2 / iPad mini
    SPLASH_PORTRAIT_STBx2  ( "Default-Portrait@2x.png"       , 1536  , 2008  , 2    ), // iPad 3 or later
    SPLASH_LANDSCAPE_STB   ( "Default-Landscape.png"         , 1024  , 748   , 1    ), // iPad / iPad2 / iPad mini
    SPLASH_LANDSCAPE_STBx2 ( "Default-Landscape@2x.png"      , 2048  , 1496  , 2    ), // iPad 3 or later
	;

	private String filename;
	private Dimension size;
	private int scale;
	private IOSSplashInfo(String filename, int width, int height, int scale) {
		this.filename = filename;
		this.size = new Dimension(width, height);
		this.scale = scale;
	}
	@Override public String getFilename() { return this.filename; }
	@Override public Dimension getSize() { return this.size; }
	@Override public int getScale() { return this.scale; }
}
