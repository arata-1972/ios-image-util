ios-image-util
==============

OVERVIEW

このjavaプログラムは、iOS6以前、およびiOS7のアイコン＆起動イメージを、必要とされる全てのサイズで生成します。

iOS6用とiOS7用では若干アイコンの仕様が異なる為、別々に元画像を指定できるようにしてあります（多少ズレても構わなければ、１つのPNG画像から全てのアイコンを出力できます。いまなら、iOS7用に１つ用意すれば、大抵の場合で事足りると思われます）。

起動イメージは、1536×1536ピクセルの正方形PNG画像を元にして、全てのサイズを出力します。その際、元画像は中央に配置され、左上の点の色が背景色になります。正方形でなくても構いませんが、特にユニバーサルな場合は一番楽にそれっぽくなると思います。

何か問題がある場合や仕様にご不満がある場合は、自由に改変してください。コンパイルをしたくない場合は、起動可能なjarファイルをご利用ください。

<img src="https://github.com/gootara-org/ios-image-util/blob/master/ios-image-util/docs/screen_ja.png?raw=true" />

以下、出力されるファイル一覧。
<table border="1">
	<tr>
		<th>Version</th>
		<th>Type</th>
		<th>Filename</th>
		<th>Width</th>
		<th>Height</th>
		<th>Description</th>
	</tr>
	<tr>
		<td rowspan="8">iOS6 or lower</td>
		<td rowspan="8">Icon</td>
		<td>Icon.png</td>
		<td align="right">57</td>
		<td align="right">57</td>
		<td>iPhone 3G / 3GS</td>
	</tr>
	<tr>
		<td>Icon@2x.png</td>
		<td align="right">114</td>
		<td align="right">114</td>
		<td>iPhone4 or later</td>
	</tr>
	<tr>
		<td>Icon-72.png</td>
		<td align="right">72</td>
		<td align="right">72</td>
		<td>iPad / iPad2 / iPad mini</td>
	</tr>
	<tr>
		<td>Icon-72@2x.png</td>
		<td align="right">144</td>
		<td align="right">144</td>
		<td>iPad3 or later</td>
	</tr>
	<tr>
		<td>Icon-Small.png</td>
		<td align="right">29</td>
		<td align="right">29</td>
		<td>iPhone3G / 3GS / iPad / iPad2 / iPad mini</td>
	</tr>
	<tr>
		<td>Icon-Small@2x.png</td>
		<td align="right">58</td>
		<td align="right">58</td>
		<td>iPhone4 / iPad3 or later</td>
	</tr>
	<tr>
		<td>Icon-Small-50.png</td>
		<td align="right">50</td>
		<td align="right">50</td>
		<td>iPad / iPad2 / iPad mini</td>
	</tr>
	<tr>
		<td>Icon-Small-50@2x.png</td>
		<td align="right">100</td>
		<td align="right">100</td>
		<td>iPad3 or later</td>
	</tr>
	<tr>
		<td rowspan="7">iOS7 or upper</td>
		<td rowspan="7">Icon</td>
		<td>Icon-60@2x.png</td>
		<td align="right">120</td>
		<td align="right">120</td>
		<td>iPhone4 or later</td>
	</tr>
	<tr>
		<td>Icon-76.png</td>
		<td align="right">76</td>
		<td align="right">76</td>
		<td>iPad / iPad2 / iPad mini</td>
	</tr>
	<tr>
		<td>Icon-76@2x.png</td>
		<td align="right">152</td>
		<td align="right">152</td>
		<td>iPad3 or later</td>
	</tr>
	<tr>
		<td>Icon-Small-40.png</td>
		<td align="right">40</td>
		<td align="right">40</td>
		<td>iPad2 / iPad mini</td>
	</tr>
	<tr>
		<td>Icon-Small-40@2x.png</td>
		<td align="right">80</td>
		<td align="right">80</td>
		<td>iPhone4 / iPad3 or later</td>
	</tr>
	<tr>
		<td>iTunesArtwork</td>
		<td align="right">512</td>
		<td align="right">512</td>
		<td>iTunes Artwork</td>
	</tr>
	<tr>
		<td>iTunesArtwork@2x</td>
		<td align="right">1024</td>
		<td align="right">1024</td>
		<td>iTunes Artwork(Retina)</td>
	</tr>
	<tr>
		<td rowspan="11">Splash</td>
		<td rowspan="7">(default)</td>
		<td>Default.png</td>
		<td align="right">320</td>
		<td align="right">480</td>
		<td>iPhone 3G / 3GS</td>
	</tr>
	<tr>
		<td>Default@2x.png</td>
		<td align="right">640</td>
		<td align="right">960</td>
		<td>iPhone4 / 4S</td>
	</tr>
	<tr>
		<td>Default-568h@2x.png</td>
		<td align="right">640</td>
		<td align="right">1136</td>
		<td>iPhone 5 or later</td>
	</tr>
	<tr>
		<td>Default-Portrait~ipad.png</td>
		<td align="right">768</td>
		<td align="right">1024</td>
		<td>iPad / iPad2 / iPad mini</td>
	</tr>
	<tr>
		<td>Default-Portrait@2x~ipad.png</td>
		<td align="right">1536</td>
		<td align="right">2048</td>
		<td>iPad 3 or later</td>
	</tr>
	<tr>
		<td>Default-Landscape~ipad.png</td>
		<td align="right">1024</td>
		<td align="right">768</td>
		<td>iPad 3 or later</td>
	</tr>
	<tr>
		<td>Default-Landscape@2x~ipad.png</td>
		<td align="right">2048</td>
		<td align="right">1536</td>
		<td>iPad 3 or later</td>
	</tr>
	<tr>
		<td rowspan="4">(optional)</td>
		<td>Default-Portrait.png</td>
		<td align="right">768</td>
		<td align="right">1004</td>
		<td>iPad / iPad2 / iPad mini</td>
	</tr>
	<tr>
		<td>Default-Portrait@2x.png</td>
		<td align="right">1536</td>
		<td align="right">2008</td>
		<td>iPad 3 or later</td>
	</tr>
	<tr>
		<td>Default-Landscape.png</td>
		<td align="right">1024</td>
		<td align="right">748</td>
		<td>iPad / iPad2 / iPad mini</td>
	</tr>
	<tr>
		<td>Default-Landscape@2x.png</td>
		<td align="right">2048</td>
		<td align="right">1496</td>
		<td>iPad 3 or later</td>
	</tr>
</table>



PREREQUISITES

- JDK 1.6 以上

RECOMMENDED

- いかなる外部ライブラリも利用していませんので、コンパイルは JDK のみで行えます。お好みで Eclipse、Ant、Maven 等も利用できます。

- Eclipse Java Development Tools (外部ライブラリを使用していませんので、バージョンはなんでも構いません)

- Ant (バージョンはなんでも構いません。1.9.3で動作確認しました。コンソール上で build.xml と同じディレクトリに移動して、単に「ant」を実行してください)

- Maven (バージョンはなんでも構いません。3.1.1で動作確認しました。コンソール上で pom.xml と同じディレクトリに移動して、単に「mvn clean compile jar:jar」を実行してください)


COMMAND LINE

- java -jar ios-image-util.jar

または、以下のようにメインクラスを指定して実行してください。

- java -classpath ios-image-util.jar org.gootara.ios.image.util.IOSImageUtil



CHANGE LOG

2014/01/15
- Change output filenames suitable for the xcode 5.
- "Generate old size of Splash images for iPad" checkbox was added.(optional)

2014/01/29
- Add new output option. iPhone only, iPad only or both.
- "Fit iPhone's Splash images to the screen" checkbox was added.
- Change optional output filenames.

2014/02/01
- Add two splash scaling options. (No resizing)

2014/02/14
- Add build.xml for Ant and pom.xml for Maven.



