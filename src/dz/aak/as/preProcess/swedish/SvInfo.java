package dz.aak.as.preProcess.swedish;

import dz.aak.as.preProcess.lang.PreProcessInfo;

public class SvInfo implements PreProcessInfo {

	@Override
	public String getISO639_1() {
		return "sv";
	}

	@Override
	public String getLangEnglishName() {
		return "Swedish";
	}

	@Override
	public String getLangName() {
		return "svenska";
	}

	@Override
	public String getPrefix() {
		return "Sv";
	}

}
