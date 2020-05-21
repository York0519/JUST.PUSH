package com.example.demo.utils.sessionlisten;

import java.io.Console;
import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import org.apache.commons.codec.binary.Base64;
import org.springframework.data.redis.connection.ClusterInfo;

import com.example.demo.utils.RsaUtils;

import lombok.extern.log4j.Log4j2;

/**
 * @author York
 *
 */
@Log4j2
public class SessionIniter {

	private static SessionIniter _instance;

	public static SessionIniter getInstance() {
		if (_instance == null) {
			_instance = new SessionIniter();
		}
		return _instance;
	}

	/**
	 * 应用销毁时调用
	 */
	public void contextDestroyed() {
		// TODO Auto-generated method stub
		log.info("context destroyed.");
	}

	/**
	 * 应用初始化时调用.
	 */
	public void contextInitialized() {

		long beginstarttime = System.currentTimeMillis();

		/**
		 * 初始化配置
		 */
		InitConcig();

		log.info("SessionIniter Done -> {}ms", System.currentTimeMillis() - beginstarttime);

		/**
		 * 弹出浏览器，打开网址。
		 */
		// String url = "http://localhost:" +
		// HoyiCloudApplication.REQ_PORT+"/index.html";
		// try {
		// OpenExplorerUtil.browse(url);
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
	}

	private void InitConcig() {
		// 生成密钥对
		try {
			KeyPair keyPair = RsaUtils.getKeyPair();
			String privateKey = new String(Base64.encodeBase64(keyPair.getPrivate().getEncoded()));
			String publicKey = new String(Base64.encodeBase64(keyPair.getPublic().getEncoded()));
			log.info("私钥:{}", privateKey);
			log.info("公钥:{}", publicKey);
			SessionConf.HRSAPublicKey = publicKey;
			SessionConf.HRSAPrivateKey = privateKey;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("生成密钥对失败", e);
		}

//		// js通过模和公钥指数获取公钥对字符串进行加密，注意必须转为16进制
//		// 模
//		SessionConf.HRSA_Modules = SessionConf.HRSAPublicKey.getModulus().toString(16);
//		// 公钥指数
//		SessionConf.HRSA_Exponent = SessionConf.HRSAPublicKey.getPublicExponent().toString(16);
//		// 私钥指数
//		SessionConf.HRSA_private_Exponent = SessionConf.HRSAPrivateKey.getPrivateExponent().toString();
//
//		Console.Info("RSAPublicKey:" + SessionConf.HRSAPublicKey);
//		Console.Info("RSAPrivateKey:" + SessionConf.HRSAPrivateKey);
	}

}
