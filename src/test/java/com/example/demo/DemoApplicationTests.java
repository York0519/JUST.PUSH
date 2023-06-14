package com.example.demo;

import cn.hutool.core.util.ReUtil;
import com.example.demo.pattern.strategy.Context;
import com.example.demo.pattern.strategy.OperationAdd;
import com.example.demo.pattern.strategy.OperationMultiply;
import com.example.demo.pattern.strategy.OperationSubtract;
import com.example.demo.pattern.template.BallFight;
import com.example.demo.pattern.template.Football;
import com.example.demo.pattern.template.Game;
import com.example.demo.test1.QuotedPriceResultDTO;
import com.example.demo.utils.RsaUtils;
import com.example.demo.utils.StringUtils;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.platform.win32.WinDef.RECT;
import com.vdurmont.emoji.EmojiParser;
import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.security.KeyPair;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javax.imageio.ImageIO;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.apache.commons.codec.binary.Base64;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.MatOfPoint2f;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.springframework.util.CollectionUtils;

//@RunWith(SpringRunner.class)
//@SpringBootTest
@Log4j2
public class DemoApplicationTests {

  static {
    String opencvDllPath = "D:\\JUST.PUSH";
    System.setProperty("java.library.path", opencvDllPath);
//    System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
  }

	@Test
	public void contextLoads() throws Exception {
    log.warn("开始游戏");
//    StrategyPatternTest();
//    log.warn("中场休息");
//    jsoupTest();
//    robotTest();
    toMapTest();
    log.warn("游戏结束");
    Assertions.assertTrue(true);
	}

  private void toMapTest() {
    List<ResolveManageUnion> list = Lists.newArrayList();
    Map<String, ResolveManageUnion> map = list.stream()
        .collect(Collectors.toMap(ResolveManageUnion::getShoppingListId, Function.identity()));
    log.error(map);
  }

  public void robotTest() throws IOException, AWTException, UnsupportedFlavorException, TesseractException {
    // 启动外部应用程序
    ProcessBuilder pb = new ProcessBuilder("D:\\4.8.exe");
    pb.redirectErrorStream(true);
    Process p = pb.start();

    // 等待应用程序启动
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
    }

    // 获取应用程序的输入输出流
    OutputStream stdin = p.getOutputStream();
    InputStream stdout = p.getInputStream();

    // 获取当前鼠标的位置信息
    PointerInfo pointerInfo = MouseInfo.getPointerInfo();
    // 获取鼠标所在的屏幕和坐标
    int x = pointerInfo.getLocation().x;
    int y = pointerInfo.getLocation().y;
    int screenX = (int) pointerInfo.getDevice().getDefaultConfiguration().getBounds().getX();
    int screenY = (int) pointerInfo.getDevice().getDefaultConfiguration().getBounds().getY();

//    HWND hwnd = new HWND(Native.getWindowPointer(p));
    HWND hwnd = User32.INSTANCE.FindWindow(null, "v4.8");
    // 获取窗口尺寸信息
    RECT rect = new RECT();
    User32.INSTANCE.GetWindowRect(hwnd, rect);

    // 创建 Robot 对象
    Robot robot = new Robot(); // 移动鼠标到第一个输入框

    // 点击按钮
    Point inputBox2 = new Point(rect.left + 534, rect.top + 306);
    robot.mouseMove(inputBox2.x, inputBox2.y);
    robot.mousePress(InputEvent.BUTTON1_MASK);
    robot.mouseRelease(InputEvent.BUTTON1_MASK);

    Point inputBox1 = new Point(rect.left + 171, rect.top + 382);// 获取应用程序的窗口句柄
//    Point inputBox1 = new Point(rect.left + 171 - (x - screenX), rect.top + 382 - (y - screenY));// 获取记事本应用程序的窗口句柄
    robot.mouseMove(inputBox1.x, inputBox1.y);
    robot.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
    robot.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);

    // 需要输入的字符串
    String str = "hello world";

    // 将字符串拆分成单个字符，并依次模拟按键操作
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);

      // 模拟按键按下操作
      robot.keyPress(keyCode);
      // 模拟按键释放操作
      robot.keyRelease(keyCode);
    }

    // 等待应用程序输出结果
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
    }

// 将鼠标移动到输入框上
    Point inputBox3 = new Point(rect.left + 243, rect.top + 300);
    robot.mouseMove(inputBox3.x, inputBox3.y);

// 模拟点击鼠标左键
    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

// 模拟按下 Ctrl+A 键
    robot.keyPress(KeyEvent.VK_CONTROL);
    robot.keyPress(KeyEvent.VK_A);
    robot.keyRelease(KeyEvent.VK_A);
    robot.keyRelease(KeyEvent.VK_CONTROL);

// 模拟按下 Ctrl+C 键
    robot.keyPress(KeyEvent.VK_CONTROL);
    robot.keyPress(KeyEvent.VK_C);
    robot.keyRelease(KeyEvent.VK_C);
    robot.keyRelease(KeyEvent.VK_CONTROL);

// 读取剪贴板中的内容
    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    Transferable contents = clipboard.getContents(null);
    if (contents != null && contents.isDataFlavorSupported(DataFlavor.stringFlavor)) {
      String text = (String) contents.getTransferData(DataFlavor.stringFlavor);
      System.out.println("输入框的值为：" + text);
    }

    // 截取屏幕截图
    BufferedImage screenshot = robot.createScreenCapture(
        new Rectangle(rect.left, rect.top, rect.right - rect.left, rect.bottom - rect.top));
    ImageIO.write(screenshot, "png", new File("screenshot.png"));

    // 提取文字

    // 初始化Tesseract OCR
    ITesseract ocr2 = new Tesseract();
    ocr2.setDatapath(".");
    ocr2.setLanguage("eng");

    // 识别单元格中的文本
    String text2 = ocr2.doOCR(new File("screenshot.png"));
    log.warn(text2);

// 加载图像
    Mat image = Imgcodecs.imread("D:\\screenshot.png");

    // 转换为灰度图像
    Mat gray = new Mat();
    Imgproc.cvtColor(image, gray, Imgproc.COLOR_BGR2GRAY);

    // 二值化图像
    Mat binary = new Mat();
    Imgproc.threshold(gray, binary, 0, 255, Imgproc.THRESH_BINARY_INV + Imgproc.THRESH_OTSU);

    // 使用形态学操作去除噪点
    Mat kernel = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size(3, 3));
    Mat morph = new Mat();
    Imgproc.morphologyEx(binary, morph, Imgproc.MORPH_CLOSE, kernel);

    // 查找轮廓
    List<MatOfPoint> contours = new ArrayList<>();
    Mat hierarchy = new Mat();
    Imgproc.findContours(morph, contours, hierarchy, Imgproc.RETR_TREE, Imgproc.CHAIN_APPROX_SIMPLE);

    // 查找表格轮廓
    List<MatOfPoint> tableContours = new ArrayList<>();
    for (int i = 0; i < contours.size(); i++) {
      MatOfPoint contour = contours.get(i);

      // 计算轮廓的面积和周长
      double area = Imgproc.contourArea(contour);
      double perimeter = Imgproc.arcLength(new MatOfPoint2f(contour.toArray()), true);

      // 根据面积和周长筛选轮廓
      if (area > 1000 && perimeter > 100) {
        double[] hierarchyData = hierarchy.get(0, i);
        int parentIdx = (int) hierarchyData[3];

        // 判断是否为表格轮廓
        if (parentIdx == -1) {
          tableContours.add(contour);
        }
      }
    }

    // 初始化Tesseract OCR
    ITesseract ocr = new Tesseract();
    ocr.setDatapath(".");
    ocr.setLanguage("eng");

    // 查找每个单元格的位置和文本
    for (int i = 0; i < tableContours.size(); i++) {
      MatOfPoint contour = tableContours.get(i);

      // 获取单元格的外接矩形
      org.opencv.core.Rect rect2 = Imgproc.boundingRect(contour);

      // 截取单元格图像
      Mat cell = new Mat(image, rect2);

      // 将OpenCV的Mat图像转换为File对象，以便Tesseract库可以处理它
      File tempFile = File.createTempFile("ocr_input", ".png");
      Imgcodecs.imwrite(tempFile.getAbsolutePath(), cell);

      // 识别单元格中的文本
      String text = ocr.doOCR(tempFile);

      // 输出单元格的位置和文本
      System.out.println("单元格 " + (i + 1) + " 的位置：" + rect2.toString());
      System.out.println("单元格 " + (i + 1) + " 的文本：" + text);
    }

// 关闭进程
    p.destroy();
  }

  public static void main(String[] args) throws Exception {
    log.warn("开始游戏");
    StringTest2();
    log.warn("游戏结束");
  }

  private void jsoupTest() throws IOException {
    Document doc = Jsoup.connect("https://www.baidu.com/s?ie=UTF-8&wd=%E7%83%AD%E6%90%9C").get();
    Elements hotSearches = doc.select(".card-big_2cg0U .card-container_3QMk1 .hot-item_1473U a");
    for (Element hotSearch : hotSearches) {
      System.out.println(hotSearch.text());
    }
  }

  private void trimTest() {
    String a = " 12 \n \t \r 3f  rt  ";
    log.info(a.trim());
    log.info(a.replaceAll("\\s*", ""));
  }

  private void stringArraysTest() {
    String[] a = new String[]{"1", "2"};
    List<Long> collect = Arrays.stream(a).map(Long::valueOf).collect(Collectors.toList());
    log.info(collect);
  }

  private static void StringTest2() {
    Scanner sc = new Scanner(System.in);
    while (sc.hasNext()) {
      String str = sc.nextLine().toUpperCase();
      String b = sc.nextLine().toUpperCase();
      char a = b.charAt(0);
      int count = 0;
      char[] ch = str.toCharArray();
      for (char c : ch) {
        if (c == a) {
          count++;
        }
      }
      log.error(count);
    }
  }

  private static void StringTest1() {
    Scanner sc = new Scanner(System.in);
    while (sc.hasNext()) {
      String str = sc.nextLine();
      log.error(str.length() - 1 - str.lastIndexOf(" "));
    }
  }

  /**
   * 模板模式测试
   *
   * @author Yuqiang Wu
   * @since 2022/3/12 012 11:52
   */
  private void TemplatePatternTest() {
    Game game = new BallFight();
    game.play();
    log.info("\n");
    game = new Football();
    game.play();
  }

  /**
   * 策略模式测试<br />
   * 使用 Context 来查看当它改变策略 Strategy 时的行为变化
   *
   * @author Yuqiang Wu
   * @since 2022/3/12 012 11:52
   */
  private void StrategyPatternTest() {
    Context context = new Context(new OperationAdd());
    log.info("10 + 5 = " + context.executeStrategy(10, 5));

    context = new Context(new OperationSubtract());
    log.info("10 - 5 = " + context.executeStrategy(10, 5));

    context = new Context(new OperationMultiply());
    log.info("10 * 5 = " + context.executeStrategy(10, 5));
  }

  private void toPercentage() {
    StringBuilder builder = new StringBuilder("a");
    builder.append(1);
    builder.append(",");
    builder.append(2);
    builder.append(",");
    builder.delete(builder.length()-1, builder.length());
    log.error(builder.toString());
    ReUtil.replaceAll("", "", "");
    org.apache.commons.lang3.StringUtils.replaceAll("", "", "");
  }

  private void logTest() {
    System.out.println("hello world");
    log.error("红色日志");
    log.warn("紫色");
    log.info("无色");
  }

	private void currentPathTest() {
	  log.warn(System.getProperty("user.dir"));
  }

	private void subListTest() {
    List<Object> objects = Lists.newArrayList();
    log.warn(objects.subList(0,objects.size()));
  }

	private void containsTest() {
	  log.warn(Lists.newArrayList().contains(1));
  }

	private void isContainChineseTest(String str) {
    boolean isContainChinese = StringUtils.isContainChinese(str);
    log.warn(isContainChinese);
    if (!isContainChinese)
      log.warn(StringUtils.toDBC(str));
  }

	private void splitTest() {
    log.warn("".split("#"));
    log.warn(Lists.newArrayList("".split("#")));
  }

	private void replaceSpaceTest() {
	  String html = " 123 456   　　  789 \n"
        + "  a\t  b\t c\r ";
    String s = replaceBlank(html);
    log.warn(s);
    log.warn(html.replace("\\s+", "").trim());
    log.warn(html.replace("\\s+", ""));
    log.warn(html.replace("\\s+\\g", ""));
  }

  public static String replaceBlank(String string) {
    String regEx = "(\\s|\\t|\\r|\\n|　)+";
    Pattern pattern = Pattern.compile(regEx);
    Matcher matcher = pattern.matcher(string);
    return matcher.replaceAll("");
  }

	private void emptyMapTest() {
    HashMap<Object, Object> objectObjectHashMap = Maps.newHashMap();
    Set<Object> objects = objectObjectHashMap.keySet();
    log.warn(objects.contains("1"));
  }

	private void bigDecimalTest() {
    log.warn(BigDecimal.ZERO);
    log.warn(BigDecimal.valueOf(0.00));
    log.warn((float)System.currentTimeMillis());
  }

	private void printFloatSystemTimeTest() {
    Date date = new Date(System.currentTimeMillis());
    log.warn(date);
    log.warn(System.currentTimeMillis());
    log.warn((float)System.currentTimeMillis());
  }

	private void nullEqualTest() {
	  Integer a = null;
	  log.warn(1 == a);
  }

	private void nullFalseTest() {
	  log.warn(null == Boolean.FALSE);
	  Boolean a = false;
	  log.warn(null == a);
	  log.warn(a);
  }

	private void newMapTest() {
    Map<String, String> map = new HashMap<>();
    for (Map.Entry<String, String> value: map.entrySet()) {

    }
    log.warn("no error");
  }

	private void emojiTest() {
    String str = "Here is a boy: 😒!";
    log.warn("原始字符为：\n" + str);

    log.warn("to aliases 之后：");
    log.warn(EmojiParser.parseToAliases(str));
    log.warn(EmojiParser.parseToAliases(str, EmojiParser.FitzpatrickAction.PARSE));
    log.warn(EmojiParser.parseToAliases(str, EmojiParser.FitzpatrickAction.REMOVE));
    log.warn(EmojiParser.parseToAliases(str, EmojiParser.FitzpatrickAction.IGNORE));
  }

	private void garbledTest() {
	  log.warn("      发器");
	  log.warn("������发器");
    log.warn("😒");
    log.warn("😒".codePoints().toString());
  }

  private void RSATest() {
    try {
      // 生成密钥对
      KeyPair keyPair = RsaUtils.getKeyPair();
      String privateKey = new String(Base64.encodeBase64(keyPair.getPrivate().getEncoded()));
      String publicKey = new String(Base64.encodeBase64(keyPair.getPublic().getEncoded()));
      System.out.println("私钥:" + privateKey);
      System.out.println("公钥:" + publicKey);
      // RSA加密
      String data = "{\"vin\":\"WAUAYA8XXCB035669\",\"carBrandId\":\"AUDI\",\"carBrandName\":\"奥迪\",\"carModelName\":\"进口奥迪 奥迪A1 Ambition 1,4A1\",\"userName\":\"猴哥\",\"userId\":\"xablqc\",\"contactNumber\":\"18696227678\",\"openInvoiceType\":\"YES\",\"qualities\":[\"ORIGINAL_BRAND\",\"EXTERNAL_BRAND\",\"INTERNAL_BRAND\",\"ORIGINAL_OTHERS\",\"OTHER_BRAND\"],\"storeIds\":[],\"source\":\"ANDROID\",\"selectBrandFlag\":\"Y\",\"isAnonymous\":1,\"vinPicture\":\"http://jk-mobile.oss-cn-shenzhen.aliyuncs.com/vin/production/success/00010722_124958_VIN_LFV3A28K6G3029712.jpg\",\"requireItemInvoice\":true,\"geoProvinceId\":\"24\",\"geoProvinceName\":\"枣阳省\",\"geoCityId\":\"240\",\"geoCityName\":\"枣阳市\",\"countyGeoId\":\"2401\",\"countyGeoName\":\"枣阳区\",\"garageCompanyName\":\"猴哥牛B\",\"garageCompanyId\":\"10762\",\"picDemand\":[\"NAMEPLATE\"],\"picDemandUrls\":[{\"mediaType\":\"PICTURE\",\"typeId\":\"NONE\",\"url\":\"http://jk-mobile.oss-cn-shenzhen.aliyuncs.com/vin/production/success/00010722_124958_VIN_LFV3A28K6G3029712.jpg\"}],\"simpleInquiryBatchItems\":[{\"content\":\"雨刮片（）《》<>|<>\",\"mediaType\":\"AUDIO\",\"url\":\"https://jk-upload.oss-cn-shenzhen.aliyuncs.com/test/agentBuy/2019-08-10/blzcw_20190810164718.wav\",\"itemNum\":0,\"description\":\"22\"}]}";
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

	private void replaceTest() {
	  String str = "”ite“ ite ite ";
	  log.error(str.replace("te", "i").replaceAll("”", "\\\"").replaceAll("“", "\\\""));
  }

	private void substringTest() {
	  String vin = "-";
    log.error(StringUtils.substring(vin, vin.length() - 4));
  }

	private void thisTest() {
    QuotedPriceResultDTO quotedPriceResultDTO = new QuotedPriceResultDTO();
    quotedPriceResultDTO.setCountryDistance(new Double(1));
    log.error(quotedPriceResultDTO.validate());
  }

	private void newListTest() {
    List<Boolean> list = Lists.newArrayList();
	  list.stream().filter(p -> p).collect(Collectors.toList());
	  list.stream().collect(Collectors.toMap(Function.identity(), Function.identity(), (k1, k2) -> k1));
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
   * @return: java.util.List<com.example.demo.DemoApplicationTests.ResolveManageUnion>
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