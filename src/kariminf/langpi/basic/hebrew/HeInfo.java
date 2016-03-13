package kariminf.langpi.basic.hebrew;

import kariminf.langpi.basic.PreProcessInfo;

public class HeInfo implements PreProcessInfo {

	@Override
	public String getISO639_1() {
		return "he";
	}

	@Override
	public String getLangEnglishName() {
		return "Hebrew";
	}

	@Override
	public String getLangName() {
		return "עברית";
	}

	@Override
	public String getPrefix() {
		return "He";
	}

}