package br.ufrn.imd.lp2.io;

import br.ufrn.imd.lp2.domain.DataBase;

public class Main {

	public static void main(String[] args) {
		
		DataBase db = new DataBase();
		db.lerUser("src/br/ufrn/imd/lp2/files/ldap.csv");
		db.ler("src/br/ufrn/imd/lp2/files/device.csv");
		//db.checkDates();
		//db.checkPcs();
		//db.checkActions();
		//db.checkDevices();
		db.userInfo("RES0962");
	}
}
