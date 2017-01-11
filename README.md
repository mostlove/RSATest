# 请求参数加密规范

流程：

- **移动端用RSA加密参数**
- **服务器对加密数据解密**



### 参数加密规则
把请求参数拼接成请求字符串( 如 userName=hello&pwd=word),参数中 必须包含 timestamp 和 type 字段(timestamp: 当前时间戳 / 1000  type: 移动端固定为 APP)

 - 对待提交的参数字符串进行Base64编码；
 - 用服务端提供的私钥进行加密;
 - 参数提交 参数名: param_rsa 参数名由服务端自定义.

### 不需要加密的请求
如果不需要对请求进行加密 或者 没有参数 则 不传 param_rsa 参数 (包括空字符串)

### 服务器端的操作
服务器的逻辑验证 在 com.magicbeans.filter.AuthenticationFilter 类

