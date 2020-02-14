package br.com.empresa.almintegration.evidences.styles;

import org.odftoolkit.odfdom.dom.attribute.fo.FoHyphenateAttribute;
import org.odftoolkit.odfdom.dom.attribute.fo.FoMarginAttribute;
import org.odftoolkit.odfdom.dom.attribute.style.StyleAutoUpdateAttribute;
import org.odftoolkit.odfdom.dom.attribute.style.StyleDisplayNameAttribute;
import org.odftoolkit.odfdom.pkg.OdfName;

public enum TableOfContentsStyles {
	;
	public enum Properties implements EvidencesProperties {
		Style_Display_Name_Attribute(StyleDisplayNameAttribute.ATTRIBUTE_NAME),
		Style_Auto_Update_Attribute(StyleAutoUpdateAttribute.ATTRIBUTE_NAME);
		private OdfName odfName;
		Properties(OdfName odfName){
			this.odfName = odfName;
		}
		@Override
		public OdfName getOdfName() {
			return odfName;
		}
		
	}
	
	public enum ParagraphProperties implements EvidencesProperties {
		Fo_Margin_Bottom_Attribute(FoMarginAttribute.ATTRIBUTE_NAME);
		private OdfName odfName;

		ParagraphProperties(OdfName odfName) {
			this.odfName = odfName;
		}

		@Override
		public OdfName getOdfName() {
			return odfName;
		}
	}
	
	public enum TextProperties implements EvidencesProperties {
		Fo_Hyphenate_Attribute(FoHyphenateAttribute.ATTRIBUTE_NAME);
		private OdfName odfName;

		TextProperties(OdfName odfName) {
			this.odfName = odfName;
		}

		@Override
		public OdfName getOdfName() {
			return odfName;
		}
	}
}
