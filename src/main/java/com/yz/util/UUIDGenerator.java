package com.yz.util;

import org.apache.commons.lang.StringUtils;

import java.io.Serializable;
import java.net.InetAddress;
import java.util.Date;
import java.util.Random;

/**
 * 
 * Title: JGSPATROLSYSTEM<br>
 * Description: Hibernate中UUID的生成算法<br>
 * Copyright: Copyright (c)	2016 <br>
 * Create DateTime: 2016-11-25 上午10:21:54 <br>
 * CVS last modify person: fuxiaorong-len <br>
 * CVS last modify DateTime: 2016-11-25 <br>
 *
 * @author fuxiaorong-len
 */
public class UUIDGenerator {
	private static final int IP;

	public static int IptoInt(byte[] bytes) {
		int result = 0;
		for (int i = 0; i < 4; i++) {
			result = (result << 8) - Byte.MIN_VALUE + (int) bytes[i];
		}
		return result;
	}

	static {
		int ipadd;
		try {
			ipadd = IptoInt(InetAddress.getLocalHost().getAddress());
		} catch (Exception e) {
			ipadd = 0;
		}
		IP = ipadd;
	}
	private static short counter = (short) 0;
	private static final int JVM = (int) (System.currentTimeMillis() >>> 8);

	public UUIDGenerator() {
	}

	/**
	 * Unique across JVMs on this machine (unless they load this class in the
	 * same quater second - very unlikely)
	 */
	protected int getJVM() {
		return JVM;
	}

	/**
	 * Unique in a millisecond for this JVM instance (unless there are >
	 * Short.MAX_VALUE instances created in a millisecond)
	 */
	protected short getCount() {
		synchronized (UUIDGenerator.class) {
			if (counter < 0)
				counter = 0;
			return counter++;
		}
	}

	/**
	 * Unique in a local network
	 */
	protected int getIP() {
		return IP;
	}

	/**
	 * Unique down to millisecond
	 */
	protected short getHiTime() {
		return (short) (System.currentTimeMillis() >>> 32);
	}

	protected int getLoTime() {
		return (int) System.currentTimeMillis();
	}

	private final static String sep = "";

	protected String format(int intval) {
		String formatted = Integer.toHexString(intval);
		StringBuffer buf = new StringBuffer("00000000");
		buf.replace(8 - formatted.length(), 8, formatted);
		return buf.toString();
	}

	protected String format(short shortval) {
		String formatted = Integer.toHexString(shortval);
		StringBuffer buf = new StringBuffer("0000");
		buf.replace(4 - formatted.length(), 4, formatted);
		return buf.toString();
	}

	public Serializable generate() {
		return new StringBuffer(36).append(format(getIP())).append(sep)
				.append(format(getJVM())).append(sep)
				.append(format(getHiTime())).append(sep)
				.append(format(getLoTime())).append(sep)
				.append(format(getCount())).toString();
	}

	public  static String randomDateUUID(String scenecode){
		String result = StringUtils.isBlank(scenecode) ? "" : scenecode;
		result = scenecode.concat(DateUtils.format(new Date(), "yyyyMMdd"));
		Random random = new Random();
		String randomNum = String.valueOf(random.nextInt(10000));
		int zeroLength = 4 - randomNum.length();
		if (zeroLength > 0) {
			for(int i = 0; i < zeroLength; ++i) {
				result = result.concat("0");
			}
		}
		result = result.concat(randomNum);
		return result;
	}

}