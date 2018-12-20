package com.github.candyacao.o2o;

public interface IO2OMapper {
	int saveWife(Wife wife);
	int saveHusband(Husband husband);
	Wife selectWifeByID(int id);
	Husband selectHusByID(int husId);
	Husband selectHusAndWifeByID(int husId);
	Husband selectHusAndWifeByID2(int husId);
}
