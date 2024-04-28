package com.example.common.kit;

import java.util.regex.Pattern;

public final class ValidateKit {

    private ValidateKit(){}

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$");
    private static final Pattern MOBILE_PATTERN = Pattern.compile("^1[3|5|7|8][0-9]{9}$");

    public static final Pattern ID_PATTERN = Pattern.compile("(^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}$)");
    public static final Pattern PASSPORT_PATTERN = Pattern.compile("^1[45][0-9]{7}|G[0-9]{8}|P[0-9]{7}|S[0-9]{7,8}|D[0-9]+$");

    /**
     * 验证Email
     * @param email email地址，格式：zhangsan@sina.com，zhangsan@xxx.com.cn，xxx代表邮件服务商
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean checkEmail(String email) {
        return EMAIL_PATTERN.matcher(email).matches();
    }

    /**
     * 验证身份证号码
     * @param idCard 居民身份证号码15位或18位，最后一位可能是数字或字母
     * 规则：前6位地区，后面几位是出生年月日，15位的年份格式yy 18位的为yyyy 紧接着3位顺序码，尾数奇数则是男 偶数为女 18位有一位校验码[1-9X]
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean checkCardNo(String cardNo) {
        return ID_PATTERN.matcher(cardNo).matches();
    }

    /**
     * 验证手机号码（支持国际格式，+86135xxxx...（中国内地），+00852137xxxx...（中国香港））
     * @param mobile 移动、联通、电信运营商的号码段
     *<p>移动的号段：134(0-8)、135、136、137、138、139、147（预计用于TD上网卡）
     *、150、151、152、157（TD专用）、158、159、187（未启用）、188（TD专用）</p>
     *<p>联通的号段：130、131、132、155、156（世界风专用）、185（未启用）、186（3g）</p>
     *<p>电信的号段：133、153、180（未启用）、189</p>
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean checkPhone(String phone) {
        return MOBILE_PATTERN.matcher(phone).matches();
    }
    
    /*校验是否为数字*/
    public static boolean checkNumber(String phone) {
    	return MOBILE_PATTERN.matcher(phone).matches();
    }

    /**
     * 验证护照号码
     * @param passport
     * 规则：因私普通护照号码格式有:14/15+7位数,G+8位数；因公普通的是:P.+7位数；
       公务的是：S.+7位数 或者 S+8位数,以D开头的是外交护照.D=diplomatic
     * @return
     */
    public static boolean checkPassport(String passport) {
        return PASSPORT_PATTERN.matcher(passport).matches();
    }
    
    public static void main(String[] args) {
    	String reg = "^1[3|5|7|8][0-9]{9}$";
    	String phone = "15001089196";
    	boolean b = Pattern.compile(reg).matcher(phone).matches();
    	System.out.println(b);
    }
}
