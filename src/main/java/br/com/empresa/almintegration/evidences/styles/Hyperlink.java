package br.com.empresa.almintegration.evidences.styles;

import org.odftoolkit.odfdom.dom.attribute.fo.FoColorAttribute;
import org.odftoolkit.odfdom.dom.attribute.style.StyleDisplayNameAttribute;
import org.odftoolkit.odfdom.dom.attribute.style.StyleParentStyleNameAttribute;
import org.odftoolkit.odfdom.dom.attribute.style.StyleTextUnderlineModeAttribute;
import org.odftoolkit.odfdom.dom.attribute.style.StyleTextUnderlineStyleAttribute;
import org.odftoolkit.odfdom.dom.attribute.style.StyleTextUnderlineTypeAttribute;
import org.odftoolkit.odfdom.dom.attribute.style.StyleTextUnderlineWidthAttribute;
import org.odftoolkit.odfdom.pkg.OdfName;

public enum Hyperlink {
	;
	enum Properties implements EvidencesProperties{
		STYLE_DISPLAY_NAME_ATTRIBUTE(StyleDisplayNameAttribute.ATTRIBUTE_NAME),
		STYLE_PARENT_STYLE_NAME_ATTRIBUTE(StyleParentStyleNameAttribute.ATTRIBUTE_NAME);
		OdfName odfName;
		Properties(OdfName odfName){
			this.odfName = odfName;
		}
		@Override
		public OdfName getOdfName() {
			return odfName;
		}
	}
	
	enum TextProperties implements EvidencesProperties {
		Fo_Color(FoColorAttribute.ATTRIBUTE_NAME),
		Style_Text_Underline_Type(StyleTextUnderlineTypeAttribute.ATTRIBUTE_NAME),
		Style_Text_Underline_Style(StyleTextUnderlineStyleAttribute.ATTRIBUTE_NAME),
		Style_Text_Underline_Width(StyleTextUnderlineWidthAttribute.ATTRIBUTE_NAME),
		Style_Text_Underline_Mode(StyleTextUnderlineModeAttribute.ATTRIBUTE_NAME);
		OdfName odfName;
		TextProperties (OdfName odfName){
			this.odfName = odfName;
		}
		@Override
		public OdfName getOdfName() {
			return odfName;
		}
	}
}
