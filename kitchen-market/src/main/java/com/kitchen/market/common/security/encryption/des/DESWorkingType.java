package com.kitchen.market.common.security.encryption.des;

/**
 * DES算法的工作模式
 *
 * ECB，中文名“电子密码本模式”，是最古老、最简单的模式，将加密的数据分成若干组，每组的大小跟加密密钥长度相同。然后每组都用相同的密钥加密，比如 DES 算法，如果最后一个分组长度不够 64 位，要补齐 64 位。
 * CBC，中文名“加密块链模式”，与 ECB 模式最大的不同是加入了初始向量。他的特点是，每次加密的密文长度为 64位 ( 8 个字节)，当相同的明文使用相同的密钥和初始向量的时候 CBC 模式总是产生相同的密文。
 * CFB，中文名“加密反馈模式”，加密反馈模式克服了需要等待 8 个字节才能加密的缺点，它采用了分组密码作为流密码的密钥流生成器。他的特点是，每次加密的 Pi 和 Ci 不大于 64 位；加密算法和解密算法相同，不能适用于公钥算法；使用相同的密钥和初始向量的时候，相同明文使用 CFB 模式加密输出相同的密文；可以使用不同的初始化变量使相同的明文产生不同的密文，防止字典攻击；加密强度依赖于密钥长度；加密块长度过小时,会增加循环的数量,导致开销增加；加密块长度应时 8 位的整数倍（即字节为单位）；一旦某位数据出错,会影响目前和其后 8 个块的数据。
 * OFB，中文名“输出反馈模式”，与 CFB 模式不同之处在于, 加密位移寄存器与密文无关了,仅与加密 key 和加密算法有关，做法是不再把密文输入到加密移位寄存器，而是把输出的分组密文（Oi）输入到一位寄存器。因为密文没有参与链操作，所以使得 OFB 模式更容易受到攻击；不会进行错误传播，某位密文发生错误，只会影响该位对应的明文，而不会影响别的位；不是自同步的，如果加密和解密两个操作失去同步，那么系统需要重新初始化；每次重新同步时，应使用不同的初始向量。可以避免产生相同的比特流，避免“已知明文”攻击。
 * CTR，中文名“计数模式”，是对一系列输入数据块(称为计数)进行加密，产生一系列的输出块，输出块与明文异或得到密文。对于最后的数据块，可能是长 u 位的局部数据块，这 u 位就将用于异或操作，而剩下的 b-u 位将被丢弃（b表示块的长度）。
 *
 * @author 赵梓彧 - kitchen_dev@163.com
 * @date 2017-09-07
 */
enum DESWorkingType {
    ECB("ECB"),
    CBC("CBC"),
    CFB("CFB"),
    OFB("OFB"),
    CTR("CTR");

    private String name;

    DESWorkingType(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
