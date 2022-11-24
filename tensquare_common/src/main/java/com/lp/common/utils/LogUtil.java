package com.lp.common.utils;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.util.StatusPrinter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;

@Slf4j
public class LogUtil {
	/**
	 * 初始化日志
	 */
	public static void init() {
		try {
			LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
			File logbackFile = ResourceUtils.getFile("classpath:logback-spring.xml");
			File externalConfigFile = logbackFile;
			if (!externalConfigFile.exists()) {
				throw new IOException("Logback配置文件不存在");
			} else {
				if (!externalConfigFile.isFile()) {
					throw new IOException("Logback配置文件不存在");
				} else {
					if (!externalConfigFile.canRead()) {
						throw new IOException("Logback配置文件不可读");
					} else {
						JoranConfigurator configurator = new JoranConfigurator();
						lc.reset();
						configurator.setContext(lc);

						configurator.doConfigure(externalConfigFile);
						StatusPrinter.printInCaseOfErrorsOrWarnings(lc);
					}
				}
			}
			StatusPrinter.setPrintStream(System.err);
		} catch (Exception e) {
			log.error("", e);
		}
	}

	/**
	 * 修改全局日志等级
	 * @param level 日志等级
	 */
	public static void chgLogLevel(String level) {
		LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
		Logger logger = loggerContext.getLogger("root");
		logger.setLevel(Level.toLevel(level.toUpperCase()));
	}

	/**
	 * 修改指定日志等级
	 * 
	 * @param logClass 类名
	 * @param logLevel 日志等级
	 */
	public static void chgLogLevel(String logClass, String logLevel) {
		LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
		Logger loggerClass = loggerContext.getLogger(logClass);
		if (loggerClass != null) {
			loggerClass.setLevel(Level.toLevel(logLevel.toUpperCase()));
		}
	}

	/**
	 * 关闭全局日志
	 */
	public static String logOff() {
		chgLogLevel("OFF");
		// chgLogLevel("com.nari.qmy.zk.curator.CuratorClient", "DEBUG");
		// chgLogLevel("com.nari.edasmain.FrontMemberMng", "DEBUG");
		return "启动日志关闭模式  \n";
	}

	/**
	 * 设置全局日志为DEBUG
	 */
	public static String logDebug() {
		chgLogLevel("DEBUG");
		return "启动DEBUG日志模式  \n";
	}

	/**
	 * 设置全局日志为INFO
	 */
	public static String logInfo() {
		chgLogLevel("INFO");
		return "启动INFO日志模式  \n";
	}

	/**
	 * 设置全局日志为ERROR
	 */
	public static String logError() {
		chgLogLevel("ERROR");
		return "启动ERROR日志模式  \n";
	}
}
