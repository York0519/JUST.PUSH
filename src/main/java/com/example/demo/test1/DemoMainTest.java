package com.example.demo.test1;

import com.google.common.collect.Lists;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.stream.Collectors;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

/**
 * @author OG02
 */
@Log4j2
public class DemoMainTest {

  private static Logger logger = LoggerFactory.getLogger(DemoMainTest.class);

  public static void main(String[] args) {

  }

  @Override
  public String toString() {
    return super.toString();
  }

  public static void setLogger(Logger logger) {
    DemoMainTest.logger = logger;
  }

  @Test
  public void test() {

    handleResolveManageUnionTest();

  }

  public void a() {
    SimpleDateFormat f = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
    String date = "1970-1-1 8:0:0";
    try {
      Date d = f.parse(date);
      logger.debug("d.getTime() -> {}", d.getTime());
      System.out.println(new Date(0));
      System.out.printf("");
      System.out.println(f.format(new Date(0)));
      System.out.println(new Date(0).getTime());
    } catch (ParseException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public void b() {
    int[] arrA = {3, 5, 0, 1, 6, 4, 2};
    int[] arrB = {2, 6, 5, 4, 3, 1, 0};
    int[] arrC = {6, 1, 4, 0, 5, 3, 2};
    logger.debug("(arrA = arrC)[4] -> {}", (arrA = arrC)[4]);

    arrA = new int[]{3, 5, 0, 1, 6, 4, 2};
    arrB = new int[]{2, 6, 5, 4, 3, 1, 0};
    arrC = new int[]{6, 1, 4, 0, 5, 3, 2};
    logger.debug("(arrC = arrB)[(arrA = arrC)[4]] -> {}", (arrC = arrB)[(arrA = arrC)[4]]);

    arrA = new int[]{3, 5, 0, 1, 6, 4, 2};
    arrB = new int[]{2, 6, 5, 4, 3, 1, 0};
    arrC = new int[]{6, 1, 4, 0, 5, 3, 2};
    logger.debug("arrA[(arrC = arrB)[(arrA = arrC)[4]]] -> {}",
        arrA[(arrC = arrB)[(arrA = arrC)[4]]]);
  }


  public void listOperation() {
    List<String> list1 = new ArrayList();
    list1.add("1111");
    list1.add("2222");
    list1.add("3333");

    List<String> list2 = new ArrayList();
    list2.add("3333");
    list2.add("4444");
    list2.add("5555");

    // 交集
    List<String> intersection = list1.stream().filter(item -> list2.contains(item))
        .collect(Collectors.toList());
    System.out.println("---得到交集 intersection---");
    intersection.parallelStream().forEach(System.out::println);

    // 差集 (list1 - list2)
    List<String> reduce1 = list1.stream().filter(item -> !list2.contains(item))
        .collect(Collectors.toList());
    System.out.println("---得到差集 reduce1 (list1 - list2)---");
    reduce1.parallelStream().forEach(System.out::println);

    // 差集 (list2 - list1)
    List<String> reduce2 = list2.stream().filter(item -> !list1.contains(item))
        .collect(Collectors.toList());
    System.out.println("---得到差集 reduce2 (list2 - list1)---");
    reduce2.parallelStream().forEach(System.out::println);

    // 并集
    List<String> listAll = list1.parallelStream().collect(Collectors.toList());
    List<String> listAll2 = list2.parallelStream().collect(Collectors.toList());
    listAll.addAll(listAll2);
    System.out.println("---得到并集 listAll---");
    listAll.parallelStream().forEach(System.out::println);

    // 去重并集
    List<String> listAllDistinct = listAll.stream().distinct().collect(Collectors.toList());
    System.out.println("---得到去重并集 listAllDistinct---");
    listAllDistinct.parallelStream().forEach(System.out::println);

    System.out.println("---原来的List1---");
    list1.parallelStream().forEach(System.out::println);
    System.out.println("---原来的List2---");
    list2.parallelStream().forEach(System.out::println);

    // 一般有filter 操作时，不用并行流parallelStream ,如果用的话可能会导致线程安全问题

  }

  public void test2() {
    String value = "2Y";
    if (value.contains("Y")) {
      System.out.println(365 * Integer.valueOf(value.substring(0, value.indexOf("Y"))));
    }
  }

  /**
   * 获取几天后的时间
   *
   * @param nextDay 需要获取的天数
   * @return Date  几天后的时间
   * @author JUM
   */
  public static Date getNextDate(int nextDay) {
    Calendar c = Calendar.getInstance(TimeZone.getDefault(), Locale.CHINA);
    c.add(Calendar.DATE, nextDay);
    Date newdate = c.getTime();
    return newdate;
  }

  public void test3() {
    System.out.println(getNextDate(-15));
  }

  public void d() {
    Date now = new Date();
// java.util.Date -> java.time.LocalDate
    LocalDate localDate = now.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
// java.time.LocalDate -> java.sql.Date
    Date newDate = java.sql.Date.valueOf(localDate);
    System.out.printf("%1$tF %1$tT\n", newDate);
  }

  public void test4() {

    List<QuotedPriceResultDTO> tempQuotedResults = Lists.newArrayList();

    List<QuotedPriceResultDTO> sortQuotedResults = Lists.newArrayList();

    tempQuotedResults.add(QuotedPriceResultDTO.builder().countryDistance(1.0).build());
    tempQuotedResults.add(QuotedPriceResultDTO.builder().countryDistance(null).build());
    tempQuotedResults.add(QuotedPriceResultDTO.builder().countryDistance(0.0).build());
    tempQuotedResults.add(QuotedPriceResultDTO.builder().countryDistance(2.0).build());

    tempQuotedResults = tempQuotedResults.stream().sorted(Comparator.nullsLast(
        Comparator.comparing(QuotedPriceResultDTO::getCountryDistance, Comparator.nullsLast(Comparator.naturalOrder())))
        .reversed())
        .collect(
            Collectors.toList());

    System.out.println(tempQuotedResults.toString());

    Integer sortValue = 1;
    BigDecimal current = BigDecimal.ZERO;
    int tempSize = tempQuotedResults.size() - 1;

//    for (int i = tempSize; i >= 0; i--) {
//
//      QuotedPriceResultDTO quotedPriceResultDTO = tempQuotedResults.get(i);
//
//      Double countryDistance = quotedPriceResultDTO.getCountryDistance();
//
//      if (null == countryDistance) {
//        continue;
//      }
//
//      BigDecimal distance = new BigDecimal(countryDistance);
//
//      if (i == tempSize) {
//        current = distance;
//      }
//
//      if (current.compareTo(distance) != 0) {
//        current = distance;
//        sortValue++;
//      }
//
//      quotedPriceResultDTO.setDistanceSortValue(sortValue);
//
//      sortQuotedResults.add(quotedPriceResultDTO);
//
//      tempQuotedResults.remove(quotedPriceResultDTO);
//    }

    if (!CollectionUtils.isEmpty(tempQuotedResults)) {
      for (QuotedPriceResultDTO quotedPriceResultDTO : tempQuotedResults) {
        quotedPriceResultDTO.setDistanceSortValue(sortValue);
      }

      sortQuotedResults.addAll(tempQuotedResults);
    }

    System.out.println(tempQuotedResults.toString());
    System.out.println(sortQuotedResults.toString());
  }

  public void handleResolveManageUnionTest() {
    ResolveManageUnion resolveManageUnion = new ResolveManageUnion();
    resolveManageUnion.setBatchCreatedStamp(new Date());
    resolveManageUnion.setShoppingListId("1");
    ResolveManageUnion resolveManageUnion2 = new ResolveManageUnion();
    resolveManageUnion2.setBatchCreatedStamp(new Date());
    resolveManageUnion2.setShoppingListId("1");
    ResolveManageUnion resolveManageUnion3 = new ResolveManageUnion();
    resolveManageUnion3.setBatchCreatedStamp(new Date());
    resolveManageUnion3.setShoppingListId("2");

    List<ResolveManageUnion> resolveManageInfos = Lists.newArrayList();
    resolveManageInfos.add(resolveManageUnion);
    resolveManageInfos.add(resolveManageUnion2);
    resolveManageInfos.add(resolveManageUnion3);

    handleResolveManageUnion(resolveManageInfos);
  }

  /**
   * 分组排序处理译码结果列表
   *
   * @param resolveManageInfos 入参
   * @return: java.util.List<com.example.demo.test1.ResolveManageUnion>
   * @author: York
   * @date: 2019/7/4 004 21:07
   */
  private List<ResolveManageUnion> handleResolveManageUnion(List<ResolveManageUnion> resolveManageInfos) {
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

    return resolveManageInfos;
  }

}

@Data
class ResolveManageUnion {
  private Date batchCreatedStamp;
  private String shoppingListId;

}
