package br.com.empresa.almintegration.evidences.styles;

import org.odftoolkit.odfdom.dom.attribute.fo.FoBreakBeforeAttribute;
import org.odftoolkit.odfdom.dom.attribute.style.StyleLeaderCharAttribute;
import org.odftoolkit.odfdom.dom.attribute.style.StyleLeaderStyleAttribute;
import org.odftoolkit.odfdom.dom.attribute.style.StyleLeaderTextAttribute;
import org.odftoolkit.odfdom.dom.attribute.style.StylePositionAttribute;
import org.odftoolkit.odfdom.dom.attribute.style.StyleTypeAttribute;
import org.odftoolkit.odfdom.dom.attribute.text.TextIndexScopeAttribute;
import org.odftoolkit.odfdom.dom.attribute.text.TextOutlineLevelAttribute;
import org.odftoolkit.odfdom.dom.attribute.text.TextStyleNameAttribute;
import org.odftoolkit.odfdom.dom.attribute.text.TextUseIndexMarksAttribute;
import org.odftoolkit.odfdom.dom.attribute.text.TextUseIndexSourceStylesAttribute;
import org.odftoolkit.odfdom.dom.attribute.text.TextUseOutlineLevelAttribute;
import org.odftoolkit.odfdom.pkg.OdfName;

public enum TableOfContents {
	;
	public enum Properties implements EvidencesProperties {
		Text_Outline_Level_Attribute(TextOutlineLevelAttribute.ATTRIBUTE_NAME),
		Text_Use_Outline_Level_Attribute(TextUseOutlineLevelAttribute.ATTRIBUTE_NAME),
		Text_Use_Index_Marks_Attribute(TextUseIndexMarksAttribute.ATTRIBUTE_NAME),
		Text_Use_Index_Source_Styles_Attribute(TextUseIndexSourceStylesAttribute.ATTRIBUTE_NAME),
		Text_Index_Scope_Attribute(TextIndexScopeAttribute.ATTRIBUTE_NAME);
		private OdfName odfName;
		Properties(OdfName odfName){
			this.odfName = odfName;
		}
		@Override
		public OdfName getOdfName() {
			return odfName;
		}
		
	}
	
	public enum TableOfContentEntryTemplateProperties implements EvidencesProperties {
		Text_Outline_Level_Attribute(TextOutlineLevelAttribute.ATTRIBUTE_NAME),
		Text_Style_Name_Attribute(TextStyleNameAttribute.ATTRIBUTE_NAME);
		
		enum IndexEntryTabStopProperties implements EvidencesProperties {
			Style_Leader_Char_Attribute(StyleLeaderCharAttribute.ATTRIBUTE_NAME),
			Text_Style_Name_Attribute(TextStyleNameAttribute.ATTRIBUTE_NAME);
			private OdfName odfName;
			IndexEntryTabStopProperties(OdfName odfName){
				this.odfName = odfName;
			}
			@Override
			public OdfName getOdfName() {
				return odfName;
			}
			
		}
		
		private OdfName odfName;
		TableOfContentEntryTemplateProperties(OdfName odfName){
			this.odfName = odfName;
		}
		@Override
		public OdfName getOdfName() {
			return odfName;
		}		
	}
	
	public enum TableOfContentTabStopProperties implements EvidencesProperties{
		Style_Type_Attribute(StyleTypeAttribute.ATTRIBUTE_NAME),
		Style_Leader_Style_Attribute(StyleLeaderStyleAttribute.ATTRIBUTE_NAME),
		Style_Leader_Text_Attribute(StyleLeaderTextAttribute.ATTRIBUTE_NAME),
		Style_Position_Attribute(StylePositionAttribute.ATTRIBUTE_NAME);
		private OdfName odfName;
		TableOfContentTabStopProperties(OdfName odfName){
			this.odfName = odfName;
		}
		@Override
		public OdfName getOdfName() {
			return odfName;
		}		
	}
	
	public enum TableOfContentsParagraphProperties implements EvidencesProperties {
		Fo_Break_Before_Attribute(FoBreakBeforeAttribute.ATTRIBUTE_NAME);
		OdfName odfName;
		TableOfContentsParagraphProperties(OdfName odfName){
			this.odfName = odfName;
		}
		@Override
		public OdfName getOdfName() {
			return odfName;
		}
	}
}
