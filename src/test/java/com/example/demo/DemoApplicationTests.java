package com.example.demo;

import com.example.demo.test1.QuotedPriceResultDTO;
import com.example.demo.utils.RsaUtils;
import com.google.common.collect.Lists;
import java.security.KeyPair;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log4j2
public class DemoApplicationTests {

	@Test
	public void contextLoads() {

    test9();

	}

  private void test9() {
    try {
      // 生成密钥对
      KeyPair keyPair = RsaUtils.getKeyPair();
      String privateKey = new String(Base64.encodeBase64(keyPair.getPrivate().getEncoded()));
      String publicKey = new String(Base64.encodeBase64(keyPair.getPublic().getEncoded()));
      System.out.println("私钥:" + privateKey);
      System.out.println("公钥:" + publicKey);
      // RSA加密
      String data = "{\"vin\":\"WAUAYA8XXCB035669\",\"carBrandId\":\"AUDI\",\"carBrandName\":\"奥迪\",\"carModelName\":\"进口奥迪 奥迪A1 Ambition 1,4A1\",\"userName\":\"猴哥\",\"userId\":\"xablqc\",\"contactNumber\":\"18696227678\",\"openInvoiceType\":\"YES\",\"qualities\":[\"ORIGINAL_BRAND\",\"EXTERNAL_BRAND\",\"INTERNAL_BRAND\",\"ORIGINAL_OTHERS\",\"OTHER_BRAND\"],\"storeIds\":[],\"source\":\"ANDROID\",\"selectBrandFlag\":\"Y\",\"isAnonymous\":1,\"vinPicture\":\"http://cass-mobile.oss-cn-shenzhen.aliyuncs.com/vin/production/success/00010722_124958_VIN_LFV3A28K6G3029712.jpg\",\"requireItemInvoice\":true,\"geoProvinceId\":\"24\",\"geoProvinceName\":\"枣阳省\",\"geoCityId\":\"240\",\"geoCityName\":\"枣阳市\",\"countyGeoId\":\"2401\",\"countyGeoName\":\"枣阳区\",\"garageCompanyName\":\"猴哥牛B\",\"garageCompanyId\":\"10762\",\"picDemand\":[\"NAMEPLATE\"],\"picDemandUrls\":[{\"mediaType\":\"PICTURE\",\"typeId\":\"NONE\",\"url\":\"http://cass-mobile.oss-cn-shenzhen.aliyuncs.com/vin/production/success/00010722_124958_VIN_LFV3A28K6G3029712.jpg\"}],\"simpleInquiryBatchItems\":[{\"content\":\"雨刮片（）《》<>|<>\",\"mediaType\":\"AUDIO\",\"url\":\"https://cass-upload.oss-cn-shenzhen.aliyuncs.com/test/agentBuy/2019-08-10/blzcw_20190810164718.wav\",\"itemNum\":0,\"description\":\"22\"}]}";
      String encryptData = RsaUtils.encrypt(data, RsaUtils.getPublicKey(publicKey));
      System.out.println("加密后内容:" + encryptData);
      // RSA解密
      String decryptData = RsaUtils.decrypt(encryptData, RsaUtils.getPrivateKey(privateKey));
      System.out.println("解密后内容:" + decryptData);

      // RSA签名
      String sign = RsaUtils.sign(data, RsaUtils.getPrivateKey(privateKey));
      // RSA验签
      boolean result = RsaUtils.verify(data, RsaUtils.getPublicKey(publicKey), sign);
      System.out.print("验签结果:" + result);
    } catch (Exception e) {
      e.printStackTrace();
      System.out.print("加解密异常");
    }
  }

	private void test8() {
	  String str = "ite ite ite ";
	  log.error(str.replace("te", "i"));
  }

	private void test7() {
	  String vin = "-";
    log.error(StringUtils.substring(vin, vin.length() - 4));
  }

	private void test6() {
    QuotedPriceResultDTO quotedPriceResultDTO = new QuotedPriceResultDTO();
    quotedPriceResultDTO.setCountryDistance(new Double(1));
    log.error(quotedPriceResultDTO.validate());
  }

	private void test5() {
    List<Boolean> list = Lists.newArrayList();
	  list.stream().filter(p -> p).collect(Collectors.toList());
	  log.error("test5");
  }

  private List<ResolveManageUnion> buildResolveManageUnion() {
    ResolveManageUnion resolveManageUnion = new ResolveManageUnion();
    resolveManageUnion.setBatchCreatedStamp(new Date().getTime());
    resolveManageUnion.setShoppingListId("1");
    ResolveManageUnion resolveManageUnion2 = new ResolveManageUnion();
    resolveManageUnion2.setBatchCreatedStamp(new Date().getTime() + 1);
    resolveManageUnion2.setShoppingListId("1");
    ResolveManageUnion resolveManageUnion3 = new ResolveManageUnion();
    resolveManageUnion3.setBatchCreatedStamp(new Date().getTime() + 2);
    resolveManageUnion3.setShoppingListId("2");
    ResolveManageUnion resolveManageUnion4 = new ResolveManageUnion();
    resolveManageUnion4.setBatchCreatedStamp(new Date().getTime() + 2);
    resolveManageUnion4.setShoppingListId("2");
    ResolveManageUnion resolveManageUnion5 = new ResolveManageUnion();
    resolveManageUnion5.setBatchCreatedStamp(new Date().getTime() + 2);
    resolveManageUnion5.setShoppingListId("3");

    List<ResolveManageUnion> resolveManageInfos = Lists.newArrayList();
    resolveManageInfos.add(resolveManageUnion);
    resolveManageInfos.add(resolveManageUnion2);
    resolveManageInfos.add(resolveManageUnion3);
    resolveManageInfos.add(resolveManageUnion4);
    resolveManageInfos.add(resolveManageUnion5);

    return resolveManageInfos;
  }

  /**
   * 分组排序处理译码结果列表
   *
   * @return: java.util.List<com.casstime.ec.cloud.inquiry.entity.union.ResolveManageUnion>
   * @author: York
   * @date: 2019/7/4 004 21:07
   */
  private List<ResolveManageUnion> handleResolveManageUnionTest() {
    List<ResolveManageUnion> resolveManageInfos = buildResolveManageUnion();
    if (CollectionUtils.isEmpty(resolveManageInfos)) {
      return Lists.newArrayList();
    }

    resolveManageInfos = resolveManageInfos
        .stream()
        .sorted(Comparator.comparing(ResolveManageUnion::getBatchCreatedStamp).reversed())
        .collect(Collectors.toList());
    if (CollectionUtils.isEmpty(resolveManageInfos)) {
      return Lists.newArrayList();
    }

    resolveManageInfos.stream().collect(Collectors.groupingBy(ResolveManageUnion::getShoppingListId));

    log.error(resolveManageInfos.stream().collect(Collectors.groupingBy(ResolveManageUnion::getShoppingListId)));

    log.error(resolveManageInfos.stream().collect(Collectors.groupingBy(ResolveManageUnion::getShoppingListId, Collectors.summarizingLong(ResolveManageUnion::getBatchCreatedStamp))));

    log.error(resolveManageInfos.stream().max(Comparator.comparing(ResolveManageUnion::getBatchCreatedStamp)).get());

    log.error(resolveManageInfos.stream().map(ResolveManageUnion::getBatchCreatedStamp).max(Long::compareTo).get());

    return resolveManageInfos;
  }

  @Data
  static class ResolveManageUnion {
    private Long batchCreatedStamp;
    private String shoppingListId;
  }

}