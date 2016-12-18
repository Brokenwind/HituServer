package com.zju.iot.common;

import java.util.regex.Pattern;


public class Constants {

	//网络连接配置
	public static final int CONNECTION_POOL_SIZE = 128; // HTTP连接连接池大小
	public static final int CONNECTION_TIME_OUT = 30000; // 连接池连接超时时间，以毫秒为单位
	
    public static final Pattern PATTERN_EMAIL = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
            "\\@" +
            "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
            "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
            ")+"
    );


	//安全加密配置 
	public static final byte[] KEY_BYTES  = { 0x6f, 0x68, 0x6d, 0x79, 0x67, 0x6f, 0x64, 0x21 };	
	public static final byte[] PUBLIC_KEY = 
		("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCEbF/Gj818bArprwhMziWQsaIGQvr/Jg6eKLo8cK1iLJT" +
		 "FPx3jn/eaivhoTbdwlzFoFrJ7cWrTFRHKaOPeRmbQl2kjTE0SSfVdGQePuZ7dYOm/40V+m9YocRP7cywsG8" +
		 "4K51DMEZZiCLrQkeCo/l1AAijlH63eHiPCPupXpuR/IwIDAQAB").getBytes();
}
