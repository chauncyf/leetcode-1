### 535. Encode and Decode TinyURL
#### 题目描述

TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk.

Design the encode and decode methods for the TinyURL service. There is no restriction on how your encode/decode algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.

#### 思路
存成键值对，然后查询比对：
```java

public class Codec {

    HashMap<Integer, String> map = new HashMap<>();
    int i = 0;
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        
        map.put(i, longUrl);
        int result = i;
        i++;
        return "http://tinyurl.com/" + result;
        
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        
        return map.get(Integer.parseInt(shortUrl.replace("http://tinyurl.com/", "")));
        
    }
}

```
讨论区有人指出了这种方式的缺陷，我认为比较严重的有：
1.如果需要多次加密同一个longURL，则会出现重复的键值对，浪费空间
2.用户可能因为这个规律过于一目了然，而利用这个规律进行一些恶意操作。
3.只用数字的话，随着url的增多，tinyurl会变得很大。打个比方：6位数字组成的url只有1000000种；6位数字和大小写字母组成的url会有(10+26x2)6=56,800,235,584种。
参考了这位同学的答案，我又重新编了一个版本：

```java

public class Codec {

    HashMap<String, String> url2code = new HashMap<>();
    HashMap<String, String> code2url = new HashMap<>();
    String base = "http://tinyurl.com/";

// encode 
    public String encode(String longurl){
        if(url2code.containsKey(longurl)) return base + url2code.get(longurl);
        String key = generateRandomShortUrl(longurl);
        while(code2url.containsKey(key)){
            key = generateRandomShortUrl(longurl);
        }
        url2code.put(longurl, key);
        code2url.put(key, longurl);
        return base + key;
        
    }

// decode 
    public String decode(String shorturl){
        return code2url.get(shorturl.replace(base,""));
    }

// generate random short url (length = 6) 
    public String generateRandomShortUrl(String longurl){
        String charset = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ01234567809";
        StringBuffer shorturl = new StringBuffer();
        for(int i=0; i<6; i++){
            shorturl.append(charset.charAt((int)(Math.random()*charset.length())));
        }
        return shorturl.toString();
    }
}

```

### 728. Self Dividing Numbers
#### 题目描述

A self-dividing number is a number that is divisible by every digit it contains.

For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.

Also, a self-dividing number is not allowed to contain the digit zero.

Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.

Example 1:
Input: 
left = 1, right = 22
Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]

#### 思路

就用了很简单粗暴的方法...
```java

    public List<Integer> selfDividingNumbers(int left, int right) {
        
        List<Integer> list = new ArrayList<>();

        for(int i = left; i <= right; i++){

        //默认这个数字是一个self-dividing number
            boolean result = true;
            int temp = i;

        //遍历个位以前的每一位，一旦出现违反规则的情况，则让result = false，并且跳出遍历；
            while(temp/10 != 0){
                if(temp%10 == 0){
                    result = false;
                    break;
                }
                int divider = temp%10;
                if(i%divider != 0){
                    result = false;
                    break;
                }
                temp = temp / 10;
            }

        //判断个位（数）是否符合要求
            int divider = temp%10;
            if(divider == 0) 
                result = false;
            else{
                if(i%divider != 0) 
                    result = false;
            }

        //只有当result此时还是true时，在list中增加该数字。
            if(result == true){
                list.add(i);
            }
            
        }

        return list;

    }

```
但是我这个代码太长啦，看见讨论区有一个版本很好：
```java

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            int j = i;
            //这里把j是个位数的情况包含进去了
            //而我是分开写的，使得代码很冗余
            for (; j > 0; j /= 10) {
                if ((j % 10 == 0) || (i % (j % 10) != 0)) break;
            }
            //这里没有另外存储一个变量进行判断，而是看j能不能走到这一步，减少了空间的使用，也让代码更精简
            if (j == 0) list.add(i); 
        }
        return list;
    }

```

### 537. Complex Number Multiplication
#### 题目描述

Given two strings representing two complex numbers.

You need to return a string representing their multiplication. Note i2 = -1 according to the definition.

Example 1:
Input: "1+1i", "1+1i"
Output: "0+2i"
Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.
Example 2:
Input: "1+-1i", "1+-1i"
Output: "0+-2i"
Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.
Note:

The input strings will not have extra blank.
The input strings will be given in the form of a+bi, where the integer a and b will both belong to the range of [-100, 100]. And the output should be also in this form.

#### 思路
就用这个式子啊....感觉这题没啥意思？
(a+bi)(c+di) = (ac - bd) + (ad+bc)i.
```java

    public String complexNumberMultiply(String a, String b) {
        String[] cd = a.split("\\+|i");
        String[] ef = b.split("\\+|i");
        int c = Integer.parseInt(cd[0]);
        int d = Integer.parseInt(cd[1]);
        int e = Integer.parseInt(ef[0]);
        int f = Integer.parseInt(ef[1]);
        return (c*e-d*f) + (d*e+c*f) + "i";
    }

```
