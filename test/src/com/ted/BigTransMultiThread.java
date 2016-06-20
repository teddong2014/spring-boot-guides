package com.ted;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BigTransMultiThread {
	public static void main(String[] args) throws Exception {
		/*Map<Integer, Long> map = new ConcurrentHashMap<Integer, Long>();
		for (int i = 0; i < 10; i++) {
			Integer threadName = (int) (Math.random() * 10);
			
			if (map.containsKey(threadName)) {
				synchronized (map.get(threadName)) {
					new Thread(String.valueOf(threadName)) {
						public void run() {
							System.out.println(">>>> " + this.getName() + " >>>>");
							try {
								Thread.currentThread().sleep(1000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							System.out.println("<<<< " + this.getName() + " <<<<");
							map.put(threadName, System.currentTimeMillis());
						};
					}.start();
				}
			} else {
				new Thread(String.valueOf(threadName)) {
					public void run() {
						System.out.println("====>>>> " + this.getName() + " >>>>");
						try {
							Thread.currentThread().sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println("====<<<< " + this.getName() + " <<<<");
						map.put(threadName, System.currentTimeMillis());
					};
				}.start();
			}
		}*/
		System.out.println("一二三四五六七八九十".length());
	}
}
