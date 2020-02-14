package br.com.empresa.almintegration.evidences.styles;

import org.odftoolkit.odfdom.dom.attribute.fo.FoBackgroundColorAttribute;
import org.odftoolkit.odfdom.dom.attribute.fo.FoBorderBottomAttribute;
import org.odftoolkit.odfdom.dom.attribute.fo.FoBorderLeftAttribute;
import org.odftoolkit.odfdom.dom.attribute.fo.FoBorderRightAttribute;
import org.odftoolkit.odfdom.dom.attribute.fo.FoBorderTopAttribute;
import org.odftoolkit.odfdom.dom.attribute.fo.FoMarginBottomAttribute;
import org.odftoolkit.odfdom.dom.attribute.fo.FoMarginLeftAttribute;
import org.odftoolkit.odfdom.dom.attribute.fo.FoMarginRightAttribute;
import org.odftoolkit.odfdom.dom.attribute.fo.FoMarginTopAttribute;
import org.odftoolkit.odfdom.dom.attribute.fo.FoMinHeightAttribute;
import org.odftoolkit.odfdom.dom.attribute.fo.FoPaddingBottomAttribute;
import org.odftoolkit.odfdom.dom.attribute.fo.FoPaddingLeftAttribute;
import org.odftoolkit.odfdom.dom.attribute.fo.FoPaddingRightAttribute;
import org.odftoolkit.odfdom.dom.attribute.fo.FoPaddingTopAttribute;
import org.odftoolkit.odfdom.dom.attribute.fo.FoPageHeightAttribute;
import org.odftoolkit.odfdom.dom.attribute.fo.FoPageWidthAttribute;
import org.odftoolkit.odfdom.dom.attribute.style.StyleAdjustmentAttribute;
import org.odftoolkit.odfdom.dom.attribute.style.StyleColorAttribute;
import org.odftoolkit.odfdom.dom.attribute.style.StyleDynamicSpacingAttribute;
import org.odftoolkit.odfdom.dom.attribute.style.StyleLineStyleAttribute;
import org.odftoolkit.odfdom.dom.attribute.style.StyleNumFormatAttribute;
import org.odftoolkit.odfdom.dom.attribute.style.StylePrintOrientationAttribute;
import org.odftoolkit.odfdom.dom.attribute.style.StyleRelWidthAttribute;
import org.odftoolkit.odfdom.dom.attribute.style.StyleWidthAttribute;
import org.odftoolkit.odfdom.dom.attribute.style.StyleWritingModeAttribute;
import org.odftoolkit.odfdom.pkg.OdfName;

public enum MainPageLayout {
	;
	enum Properties implements EvidencesProperties{
	Fo_Page_Width_Attribute(FoPageWidthAttribute.ATTRIBUTE_NAME),
	Fo_Page_Height_Attribute(FoPageHeightAttribute.ATTRIBUTE_NAME),
	Style_Print_Orientation_Attribute(StylePrintOrientationAttribute.ATTRIBUTE_NAME),
	Fo_Margin_Top_Attribute(FoMarginTopAttribute.ATTRIBUTE_NAME),
	Fo_Margin_Left_Attribute(FoMarginLeftAttribute.ATTRIBUTE_NAME),
	Fo_Margin_Bottom_Attribute(FoMarginBottomAttribute.ATTRIBUTE_NAME),
	Fo_Margin_Right_Attribute(FoMarginRightAttribute.ATTRIBUTE_NAME),
	Style_Num_Format_Attribute(StyleNumFormatAttribute.ATTRIBUTE_NAME),
	Style_Writing_Mode_Attribute(StyleWritingModeAttribute.ATTRIBUTE_NAME);
		private OdfName odfName;

		Properties(OdfName odfName) {
			this.odfName = odfName;
		}

		public OdfName getOdfName() {
			return odfName;
		}
	}

	enum HeaderFooterPropertiesElement implements EvidencesProperties {
		STYLE_DYNAMIC_SPACING_ATTRIBUTE(StyleDynamicSpacingAttribute.ATTRIBUTE_NAME), 
		FO_MIN_HEIGHT_ATTRIBUTE(FoMinHeightAttribute.ATTRIBUTE_NAME);
		private OdfName odfName;

		HeaderFooterPropertiesElement(OdfName odfName) {
			this.odfName = odfName;
		}

		@Override
		public OdfName getOdfName() {
			return odfName;
		}
	}
	
	enum FootnoteSepElement implements EvidencesProperties {
		STYLE_WIDTH_ATTRIBUTE(StyleWidthAttribute.ATTRIBUTE_NAME),
		STYLE_REL_WIDTH_ATTRIBUTE(StyleRelWidthAttribute.ATTRIBUTE_NAME),
		STYLE_COLOR_ATTRIBUTE(StyleColorAttribute.ATTRIBUTE_NAME),
		STYLE_LINE_STYLE_ATTRIBUTE(StyleLineStyleAttribute.ATTRIBUTE_NAME),
		STYLE_ADJUSTMENT_ATTRIBUTE(StyleAdjustmentAttribute.ATTRIBUTE_NAME);
		private OdfName odfName;

		FootnoteSepElement(OdfName odfName) {
			this.odfName = odfName;
		}

		@Override
		public OdfName getOdfName() {
			return odfName;
		}
	}
	
	enum TablePropertiesElement implements EvidencesProperties {
		STYLE_WIDTH_ATTRIBUTE(StyleWidthAttribute.ATTRIBUTE_NAME),
		FO_MARGIN_LEFT_ATTRIBUTE(FoMarginLeftAttribute.ATTRIBUTE_NAME);
		private OdfName odfName;
		TablePropertiesElement(OdfName odfName) {
			this.odfName = odfName;
		}

		@Override
		public OdfName getOdfName() {
			return odfName;
		}		
	}
	
	public enum TableCellPropertiesElement implements EvidencesProperties {
		FO_BORDER_TOP_ATTRIBUTE(FoBorderTopAttribute.ATTRIBUTE_NAME),
		FO_BORDER_LEFT_ATTRIBUTE(FoBorderLeftAttribute.ATTRIBUTE_NAME),
		FO_BORDER_BOTTOM_ATTRIBUTE(FoBorderBottomAttribute.ATTRIBUTE_NAME),
		FO_BORDER_RIGHT_ATTRIBUTE(FoBorderRightAttribute.ATTRIBUTE_NAME),
		STYLE_WRITING_MODE_ATTRIBUTE(StyleWritingModeAttribute.ATTRIBUTE_NAME),
		FO_PADDING_TOP_ATTRIBUTE(FoPaddingTopAttribute.ATTRIBUTE_NAME),
		FO_PADDING_LEFT_ATTRIBUTE(FoPaddingLeftAttribute.ATTRIBUTE_NAME),
		FO_PADDING_BOTTOM_ATTRIBUTE(FoPaddingBottomAttribute.ATTRIBUTE_NAME),
		FO_PADDING_RIGHT_ATTRIBUTE(FoPaddingRightAttribute.ATTRIBUTE_NAME),
		FO_BACKGROUND_COLOR_ATTRIBUTE(FoBackgroundColorAttribute.ATTRIBUTE_NAME);
		private OdfName odfName;

		TableCellPropertiesElement(OdfName odfName) {
			this.odfName = odfName;
		}

		@Override
		public OdfName getOdfName() {
			return odfName;
		}
	}

	public static TableCellPropertiesElement[] getTableCellPropertiesElement(){
		return TableCellPropertiesElement.values();
	}
}
	
	
