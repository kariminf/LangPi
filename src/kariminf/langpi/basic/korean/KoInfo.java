package kariminf.langpi.basic.korean;

import kariminf.langpi.basic.PreProcessInfo;;

public class KoInfo implements PreProcessInfo {

	@Override
	public String getISO639_1() {
		return "ko";
	}

	@Override
	public String getLangEnglishName() {
		return "Korean";
	}

	@Override
	public String getLangName() {
		return "한국어";
	}

	@Override
	public String getPrefix() {
		return "Ko";
	}

}