package br.com.empresa.almintegration.evidences.styles;

import org.odftoolkit.odfdom.dom.attribute.draw.DrawNameAttribute;
import org.odftoolkit.odfdom.dom.attribute.draw.DrawStyleNameAttribute;
import org.odftoolkit.odfdom.dom.attribute.style.StyleRelHeightAttribute;
import org.odftoolkit.odfdom.dom.attribute.style.StyleRelWidthAttribute;
import org.odftoolkit.odfdom.dom.attribute.svg.SvgHeightAttribute;
import org.odftoolkit.odfdom.dom.attribute.svg.SvgWidthAttribute;
import org.odftoolkit.odfdom.dom.attribute.svg.SvgXAttribute;
import org.odftoolkit.odfdom.dom.attribute.svg.SvgYAttribute;
import org.odftoolkit.odfdom.dom.attribute.text.TextAnchorTypeAttribute;
import org.odftoolkit.odfdom.dom.attribute.xlink.XlinkActuateAttribute;
import org.odftoolkit.odfdom.dom.attribute.xlink.XlinkHrefAttribute;
import org.odftoolkit.odfdom.dom.attribute.xlink.XlinkShowAttribute;
import org.odftoolkit.odfdom.dom.attribute.xlink.XlinkTypeAttribute;
import org.odftoolkit.odfdom.pkg.OdfName;

public enum MasterPages {
	;
	enum DrawFrameElementProperties implements EvidencesProperties {
		DRAW_STYLE_NAME_ATTRIBUTE(DrawStyleNameAttribute.ATTRIBUTE_NAME),
		DRAW_NAME_ATTRIBUTE(DrawNameAttribute.ATTRIBUTE_NAME),
		TEXT_ANCHOR_TYPE_ATTRIBUTE(TextAnchorTypeAttribute.ATTRIBUTE_NAME),
		SVG_X_ATTRIBUTE(SvgXAttribute.ATTRIBUTE_NAME),
		SVG_Y_ATTRIBUTE(SvgYAttribute.ATTRIBUTE_NAME),
		SVG_WIDTH_ATTRIBUTE(SvgWidthAttribute.ATTRIBUTE_NAME),
		SVG_HEIGHT_ATTRIBUTE(SvgHeightAttribute.ATTRIBUTE_NAME),
		STYLE_REL_WIDTH_ATTRIBUTE(StyleRelWidthAttribute.ATTRIBUTE_NAME),
		STYLE_REL_HEIGHT_ATTRIBUTE(StyleRelHeightAttribute.ATTRIBUTE_NAME);
		private OdfName odfName;

		DrawFrameElementProperties(OdfName odfName) {
			this.odfName = odfName;
		}

		@Override
		public OdfName getOdfName() {
			return odfName;
		}
	}
	
	enum ImageElementProperties implements EvidencesProperties {
		XLINK_HREF_ATTRIBUTE(XlinkHrefAttribute.ATTRIBUTE_NAME),
		XLINK_TYPE_ATTRIBUTE(XlinkTypeAttribute.ATTRIBUTE_NAME),
		XLINK_SHOW_ATTRIBUTE(XlinkShowAttribute.ATTRIBUTE_NAME),
		XLINK_ACTUATE_ATTRIBUTE(XlinkActuateAttribute.ATTRIBUTE_NAME);
		private OdfName odfName;
		ImageElementProperties(OdfName odfName) {
			this.odfName = odfName;
		}

		@Override
		public OdfName getOdfName() {
			return odfName;
		}
	}
}
