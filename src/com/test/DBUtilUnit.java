package com.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.util.DBUtil;

class DBUtilUnit {

	@Test
	void ConnectionTest() {
		assertNotNull(DBUtil.createConnection());
	}

}
