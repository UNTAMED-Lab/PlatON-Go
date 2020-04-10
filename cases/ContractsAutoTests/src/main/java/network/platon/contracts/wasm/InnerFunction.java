package network.platon.contracts.wasm;

import com.platon.rlp.datatypes.Uint64;
import java.math.BigInteger;
import java.util.Arrays;
import org.web3j.abi.WasmFunctionEncoder;
import org.web3j.abi.datatypes.WasmFunction;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.WasmContract;
import org.web3j.tx.gas.GasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://github.com/PlatONnetwork/client-sdk-java/releases">platon-web3j command line tools</a>,
 * or the org.web3j.codegen.WasmFunctionWrapperGenerator in the 
 * <a href="https://github.com/PlatONnetwork/client-sdk-java/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with platon-web3j version 0.9.1.2-SNAPSHOT.
 */
public class InnerFunction extends WasmContract {
    private static String BINARY_0 = "0x0061736d01000000014f0f60017f0060027f7f0060017f017f60000060037f7f7f0060017f017e60037f7e7e006000017e60047f7f7f7f0060037f7f7f017f60027f7e0060037f7e7f006000017f60027f7f017f60017e017f02bc010803656e760c706c61746f6e5f70616e6963000303656e7610706c61746f6e5f6761735f7072696365000203656e7613706c61746f6e5f626c6f636b5f6e756d626572000703656e7610706c61746f6e5f6761735f6c696d6974000703656e7610706c61746f6e5f74696d657374616d70000703656e7617706c61746f6e5f6765745f696e7075745f6c656e677468000c03656e7610706c61746f6e5f6765745f696e707574000003656e760d706c61746f6e5f72657475726e0001033f3e0309000302020403030d040400080001030606060300000902020202080101020002040101020101010104010a0e0b0200000505050305020000010001000405017001060605030100020615037f0141808b040b7f0041808b040b7f0041f70a0b075406066d656d6f72790200115f5f7761736d5f63616c6c5f63746f727300080b5f5f686561705f6261736503010a5f5f646174615f656e6403020f5f5f66756e63735f6f6e5f65786974001c06696e766f6b65003d090b010041010b051e3a3b3c380a98433e2400100b41a40a420037020041ac0a410036020010184101101d41b00a10371a4105101d0ba20a010d7f2002410f6a210f410020026b21072002410e6a210a410120026b210e2002410d6a210d410220026b210c0340200020056a2103200120056a220441037145200220054672450440200320042d00003a0000200f417f6a210f200741016a2107200a417f6a210a200e41016a210e200d417f6a210d200c41016a210c200541016a21050c010b0b200220056b210602400240024002402003410371220b044020064120490d03200b4101460d01200b4102460d02200b4103470d032003200120056a280200220a3a0000200041016a210b200220056b417f6a210c200521030340200c4113494504402003200b6a2208200120036a220941046a2802002206411874200a41087672360200200841046a200941086a2802002204411874200641087672360200200841086a2009410c6a28020022064118742004410876723602002008410c6a200941106a280200220a411874200641087672360200200341106a2103200c41706a210c0c010b0b2002417f6a2007416d2007416d4b1b200f6a4170716b20056b2106200120036a41016a2104200020036a41016a21030c030b2006210403402004411049450440200020056a2203200120056a2202290200370200200341086a200241086a290200370200200541106a2105200441706a21040c010b0b027f2006410871450440200120056a2104200020056a0c010b200020056a2202200120056a2201290200370200200141086a2104200241086a0b21052006410471044020052004280200360200200441046a2104200541046a21050b20064102710440200520042f00003b0000200441026a2104200541026a21050b2006410171450d03200520042d00003a000020000f0b2003200120056a2206280200220a3a0000200341016a200641016a2f00003b0000200041036a210b200220056b417d6a210720052103034020074111494504402003200b6a2208200120036a220941046a2802002206410874200a41187672360200200841046a200941086a2802002204410874200641187672360200200841086a2009410c6a28020022064108742004411876723602002008410c6a200941106a280200220a410874200641187672360200200341106a2103200741706a21070c010b0b2002417d6a200c416f200c416f4b1b200d6a4170716b20056b2106200120036a41036a2104200020036a41036a21030c010b2003200120056a2206280200220d3a0000200341016a200641016a2d00003a0000200041026a210b200220056b417e6a210720052103034020074112494504402003200b6a2208200120036a220941046a2802002206411074200d41107672360200200841046a200941086a2802002204411074200641107672360200200841086a2009410c6a28020022064110742004411076723602002008410c6a200941106a280200220d411074200641107672360200200341106a2103200741706a21070c010b0b2002417e6a200e416e200e416e4b1b200a6a4170716b20056b2106200120036a41026a2104200020036a41026a21030b20064110710440200320042d00003a00002003200428000136000120032004290005370005200320042f000d3b000d200320042d000f3a000f200441106a2104200341106a21030b2006410871044020032004290000370000200441086a2104200341086a21030b2006410471044020032004280000360000200441046a2104200341046a21030b20064102710440200320042f00003b0000200441026a2104200341026a21030b2006410171450d00200320042d00003a00000b20000bc70201027f200041003a000020004184026a2201417f6a41003a0000200041003a0002200041003a00012001417d6a41003a00002001417e6a41003a0000200041003a00032001417c6a41003a00002000410020006b41037122016a22004100360200200041840220016b417c7122026a2201417c6a4100360200024020024109490d002000410036020820004100360204200141786a4100360200200141746a410036020020024119490d002000410036021820004100360214200041003602102000410036020c200141706a41003602002001416c6a4100360200200141686a4100360200200141646a41003602002002200041047141187222026b2101200020026a2100034020014120490d0120004200370300200041186a4200370300200041106a4200370300200041086a4200370300200041206a2100200141606a21010c000b000b0b3501017f230041106b220041808b0436020c418408200028020c41076a41787122003602004180082000360200418c083f003602000b9f0101047f230041106b220224002002200036020c027f02400240024020000440418c08200041086a22014110762200418c082802006a2203360200418408200141840828020022016a41076a4178712204360200200341107420044d0d0120000d020c030b41000c030b418c08200341016a360200200041016a21000b200040000d0010000b20012002410c6a410410091a200141086a0b200241106a24000b2f01027f2000410120001b2100034002402000100c22010d004190082802002202450d0020021103000c010b0b20010bbf0301057f024020002001460d00027f02400240200120006b20026b410020024101746b4b044020002001734103712103200020014f0d012003450d0220000c030b20002001200210091a0f0b024020030d002001417f6a21040340200020026a220341037104402002450d052003417f6a200220046a2d00003a00002002417f6a21020c010b0b2000417c6a21042001417c6a2103034020024104490d01200220046a200220036a2802003602002002417c6a21020c000b000b2001417f6a210103402002450d03200020026a417f6a200120026a2d00003a00002002417f6a21020c000b000b200241046a21052002417f73210303400240200120046a2106200020046a2207410371450d0020022004460d03200720062d00003a00002005417f6a2105200341016a2103200441016a21040c010b0b200220046b2101410021000340200141044f0440200020076a200020066a280200360200200041046a21002001417c6a21010c010b0b200020066a210120022003417c2003417c4b1b20056a417c716b20046b2102200020076a0b210003402002450d01200020012d00003a00002002417f6a2102200041016a2100200141016a21010c000b000b0b0a0041940841013602000b0a0041940841003602000b4d01017f20004200370200200041086a2202410036020020012d0000410171450440200020012902003702002002200141086a28020036020020000f0b200020012802082001280204101220000b6401027f2002417049044002402002410a4d0440200020024101743a0000200041016a21030c010b200241106a4170712204100d21032000200236020420002004410172360200200020033602080b2003200120021013200220036a41003a00000f0b000b13002002047f20002001200210090520000b1a0b130020002d0000410171044020002802081a0b0b9f0101027f416f20016b41014f0440027f200041016a20002d0000410171450d001a20002802080b2105027f416f200141e6ffffff074b0d001a410b20014101742204200141016a220120012004491b2204410b490d001a200441106a4170710b2201100d21042003044020042005200310130b200220036b22020440200320046a200320056a200210130b20002004360208200020014101723602000f0b000bfc0101067f027f410a21010240027f20002d0000220241017145044020024101762103410a0c010b2000280204210320002802002202417e71417f6a0b220520034128200341284b1b2204410b4f0440200441106a417071417f6a21010b20014704402001410a460440200041016a210420002802080c030b200141016a100d2204200120054b720d010b0f0b20002d0000220241017145044041012106200041016a0c010b4101210620002802080b2105200420052002410171047f200028020405200241fe01714101760b41016a10132006044020002004360208200020033602042000200141016a4101723602000f0b200020034101743a00000b950101037f027f20002d0000220241017122040440200028020421032000280200417e71417f6a0c010b20024101762103410a0b2102027f02400240200220034604402000200220022002101520002d0000410171450d010c020b20040d010b2000200341017441026a3a0000200041016a0c010b2000200341016a36020420002802080b20036a220041003a0001200020013a00000b2301017f03402000410c470440200041a40a6a4100360200200041046a21000c010b0b0bd00202027f047e027e027e02400240027e024020025004400c010b41fd00200279a76b220341c000470d0220010c010b2001420a800c030b21072002210541c00021030c010b2003413f4d0440200241c00020036bad22078620012003ad2206888421052002200688210820012007862107420021060c010b200241800120036bad2206862001200341406aad22058884210720022005882105200120068621060b03402003044020084201862005423f8884220220054201862007423f88842201427f852205420a7c200554ad2002427f8542007c7c423f8722024200837d20012002420a83220554ad7d2108200120057d210520074201862006423f888421072003417f6a21032004ad20064201868421062002a741017121040c010b0b2004ad2006420186427e8384210120074201862006423f88840c010b210142000b210220002001370300200020023703080b3701017f230041106b220324002003200120021019200329030021012000200341086a29030037030820002001370300200341106a24000b7701017e20002001427f7e200242767e7c2001422088220242ffffffff0f7e7c200242f6ffffff0f7e200142ffffffff0f83220142f6ffffff0f7e22024220887c22034220887c200142ffffffff0f7e200342ffffffff0f837c22014220887c3703082000200242ffffffff0f832001422086843703000b7601037f100f41980828020021000340200004400340419c08419c082802002201417f6a22023602002001410148450440200020024102746a22004184016a280200200041046a2802001010110000100f41980828020021000c010b0b419c084120360200419808200028020022003602000c010b0b0b900101027f100f419808280200220145044041980841a00836020041a00821010b0240419c0828020022024120460440418402100c220104402001100a0b2001450d0120014198082802003602004198082001360200419c084100360200410021020b419c08200241016a360200200120024102746a22014184016a4100360200200141046a200036020010100f0b10100b070041a40a10140b780020004200370210200042ffffffff0f3702082000200129020037020002402002410871450d002000102020012802044f0d002002410471450440200042003702000c010b10000b024002402002411071450d002000102020012802044d0d0020024104710d01200042003702000b20000f0b100020000b290002402000280204044020002802002c0000417f4c0d0141010f0b41000f0b20001021200010226a0b240002402000280204450d0020002802002c0000417f4c0d0041000f0b2000102741016a0b8a0301047f0240024020002802040440200010284101210220002802002c00002201417f4c0d010c020b41000f0b200141ff0171220241b7014d0440200241807f6a0f0b02400240200141ff0171220141bf014d04400240200041046a22042802002201200241c97e6a22034d047f100020042802000520010b4102490d0020002802002d00010d0010000b200341054f044010000b20002802002d000145044010000b410021024100210103402001200346450440200028020020016a41016a2d00002002410874722102200141016a21010c010b0b200241384f0d010c020b200141f7014d0440200241c07e6a0f0b0240200041046a22042802002201200241897e6a22034d047f100020042802000520010b4102490d0020002802002d00010d0010000b200341054f044010000b20002802002d000145044010000b410021024100210103402001200346450440200028020020016a41016a2d00002002410874722102200141016a21010c010b0b20024138490d010b200241ff7d490d010b100020020f0b20020b3902017f017e230041306b2201240020012000290200220237031020012002370308200141186a200141086a4114101f1020200141306a24000b5e01027f2000027f027f2001280200220504404100200220036a200128020422014b2001200249720d011a410020012003490d021a200220056a2104200120026b20032003417f461b0c020b41000b210441000b360204200020043602000b2101017f20011022220220012802044b044010000b2000200120011021200210240b900302097f017e230041406a220224002001280208220341004b0440200241386a20011025200220022903383703182001200241186a102336020c200241306a20011025410021032001027f410020022802302205450d001a410020022802342207200128020c2204490d001a200720042004417f461b210820050b360210200141146a2008360200200141086a41003602000b200141106a2104200141146a21072001410c6a2105200141086a210803400240200341004f0d002007280200450d00200241306a2001102541002103027f20022802302209044041002002280234220a20052802002206490d011a200a20066b2103200620096a0c010b41000b210620072003360200200420063602002002200336022c2002200636022820022002290328370310200241306a20044100200241106a1023102420042002290330220b37020020052005280200200b422088a76a3602002008200828020041016a22033602000c010b0b20022004290200220b3703202002200b3703082000200241086a4114101f1a200241406b24000b4101017f02402000280204450d0020002802002d0000220041bf014d0440200041b801490d01200041c97e6a0f0b200041f801490d00200041897e6a21010b20010b4401017f200028020445044010000b0240200028020022012d0000418101470d00200041046a28020041014d047f100020002802000520010b2c00014100480d0010000b0b9f0101037f02402000280204044020001028200028020022022c000022014100480d0120014100470f0b41000f0b027f4101200141807f460d001a200141ff0171220341b7014d0440200041046a28020041014d047f100020002802000520020b2d00014100470f0b4100200341bf014b0d001a200041046a280200200141ff017141ca7e6a22014d047f100020002802000520020b20016a2d00004100470b0b2c002000200220016b2202102c200028020020002802046a2001200210091a2000200028020420026a3602040b9d0201077f02402001450d002000410c6a2107200041106a2105200041046a21060340200528020022022007280200460d01200241786a28020020014904401000200528020021020b200241786a2203200328020020016b220136020020010d01200520033602002000410120062802002002417c6a28020022016b2202102d220341016a20024138491b2204200628020022086a102e2004200120002802006a22046a2004200820016b100e0240200241374d0440200028020020016a200241406a3a00000c010b200341f7016a220441ff014d0440200028020020016a20043a00002000280200200120036a6a210103402002450d02200120023a0000200241087621022001417f6a21010c000b000b10000b410121010c000b000b0b1b00200028020420016a220120002802084b044020002001102f0b0b1e01017f03402000044020004108762100200141016a21010c010b0b20010b0f0020002001102f200020013602040b3901017f200028020820014904402001100c22022000280200200028020410091a20002802001a200041086a2001360200200020023602000b0b250020004101102c200028020020002802046a20013a00002000200028020441016a3602040b2b01027f2001102d220241b7016a22034180024e044010000b2000200341ff0171103020002001200210320b3d002000200028020420026a102e200028020020002802046a417f6a2100034020010440200020013a0000200141087621012000417f6a21000c010b0b0ba00101037f230041106b2202240020012802002103024002400240024020012802042201410146044020032c000022044100480d012000200441ff017110300c040b200141374b0d010b200020014180017341ff017110300c010b2000200110310b2002200136020c2002200336020820022002290308370300200020022802002201200120022802046a102a20004100102b0b20004101102b200241106a24000b830101037f02400240200150450440200142ff00560d0120002001a741ff017110300c020b200041800110300c010b024020011035220241374d0440200020024180017341ff017110300c010b2002102d220341b7016a22044180024f044010000b2000200441ff0171103020002002200310320b20002001200210360b20004101102b0b3202017f017e034020002002845045044020024238862000420888842100200141016a2101200242088821020c010b0b20010b5101017e2000200028020420026a102e200028020020002802046a417f6a21000340200120038450450440200020013c0000200342388620014208888421012000417f6a2100200342088821030c010b0b0b3601017f20004200370200200041086a410036020003402001410c46450440200020016a4100360200200141046a21010c010b0b20000b070041b00a10140b9c0202057f047e230041306b22032400200341206a2101200341206a10012102034020020440200742088620064238888421072002417f6a210220013100002006420886842106200141016a21010c010b0b2000103722001016200341186a21010340200341106a20062007101a20032003290310220820012903002209101b2000200329030020067ca741bc0a6a2c000010172006420956200742005220075020082106200921071b0d000b0240200028020420002d00002201410176200141017122011b2204450d0020042000280208200041016a20011b22026a417f6a21010340200220014f0d0120022d00002100200220012d00003a0000200120003a00002001417f6a2101200241016a21020c000b000b200341306a24000b040010020b040010030b040010040bf70602077f017e230041c0016b22002400100810052201100c22021006200020013602a401200020023602a001200020002903a001370328200041a0016a200041c8006a200041286a411c101f1026200041a0016a102802400240200041a0016a1029450d0020002802a401450d0020002802a0012d000041c001490d010b10000b200041a0016a1022220320002802a40122024b0440100020002802a40121020b20002802a001210602400240027f027f024020020440410020062c00002201417f4a0d031a200141ff0171220441bf014b0d014100200141ff017141b801490d021a200441c97e6a0c020b410120060d021a0c030b4100200141ff017141f801490d001a200441897e6a0b41016a0b21042002200349200320046a20024b720d004100210120022004490d01200420066a2101200220046b20032003417f461b22054109490d0110000c010b410021010b0340200504402005417f6a210520013100002007420886842107200141016a21010c010b0b02400240024002402007500d0041c70a103e2007510d0302400240024041cc0a103e2007510440200041e8006a1039200041f8006a103f2102200041b8016a4100360200200041b0016a4200370300200041a8016a4200370300200042003703a0014101210120004190016a200041e8006a1011220428020420002d0090012203410176200341017122051b2203450d0620034101470d012004280208200441016a20051b2c0000417f4a0d060c020b41d60a103e2007510440200041003602442000410236024020002000290340370310200041106a10400c070b41e30a103e2007520d022000410036023c2000410336023820002000290338370318200041186a10400c060b200341374b0d030b200341016a21010c030b41ed0a103e2007520d00200041003602342000410436023020002000290330370320200041206a10400c030b10000c020b2003102d20036a41016a21010b200020013602a00120041014200041a0016a41047210412002200110422000200041a0016a200041e8006a10112201280208200141016a20002d00a001220341017122041b3602900120002001280204200341017620041b3602940120002000290390013703082002200041086a103320011014200228020c200241106a28020047044010000b20022802002002280204100720021043200041e8006a10140b200041c0016a24000b3901027e42a5c688a1c89ca7f94b210103402000300000220250450440200041016a2100200142b383808080207e20028521010c010b0b20010b29002000410036020820004200370200200041001044200041146a41003602002000420037020c20000bef0102037f037e230041406a2201240041012103200120002802044101756a20002802001105002105200141086a103f210241002100200141386a4100360200200141306a4200370300200141286a42003703002001420037032020054280015a044020052106034020042006845045044020044238862006420888842106200041016a2100200442088821040c010b0b200041384f047f2000102d20006a0520000b41016a21030b20012003360220200141206a4104721041200220031042200220051034200228020c200241106a28020047044010000b20022802002002280204100720021043200141406b24000bdc0201067f200028020422012000280210220241087641fcffff07716a2103027f2001200028020822054704402001200028021420026a220441087641fcffff07716a280200200441ff07714102746a2106200041146a21042003280200200241ff07714102746a0c010b200041146a210441000b2102034020022006470440200241046a220220032802006b418020470d0120032802042102200341046a21030c010b0b20044100360200200041086a21020340200520016b410275220341034f044020012802001a200041046a2201200128020041046a2201360200200228020021050c010b0b0240200041106a027f2003410147044020034102470d024180080c010b4180040b3602000b03402001200547044020012802001a200141046a21010c010b0b200041086a22032802002101200041046a280200210203402001200247044020032001417c6a22013602000c010b0b20002802001a0b1300200028020820014904402000200110440b0b1c01017f200028020c22010440200041106a20013602000b200010450b3601017f200028020820014904402001100c200028020020002802041009210220001045200041086a2001360200200020023602000b0b080020002802001a0b0b41010041bc0a0b3a3031323334353637383900696e6974006761735f707269636500626c6f636b5f6e756d626572006761735f6c696d69740074696d657374616d70";

    public static String BINARY = BINARY_0;

    public static final String FUNC_GAS_LIMIT = "gas_limit";

    public static final String FUNC_GAS_PRICE = "gas_price";

    public static final String FUNC_BLOCK_NUMBER = "block_number";

    public static final String FUNC_TIMESTAMP = "timestamp";

    protected InnerFunction(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    protected InnerFunction(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<Uint64> gas_limit() {
        final WasmFunction function = new WasmFunction(FUNC_GAS_LIMIT, Arrays.asList(), Uint64.class);
        return executeRemoteCall(function, Uint64.class);
    }

    public RemoteCall<String> gas_price() {
        final WasmFunction function = new WasmFunction(FUNC_GAS_PRICE, Arrays.asList(), String.class);
        return executeRemoteCall(function, String.class);
    }

    public RemoteCall<Uint64> block_number() {
        final WasmFunction function = new WasmFunction(FUNC_BLOCK_NUMBER, Arrays.asList(), Uint64.class);
        return executeRemoteCall(function, Uint64.class);
    }

    public RemoteCall<Uint64> timestamp() {
        final WasmFunction function = new WasmFunction(FUNC_TIMESTAMP, Arrays.asList(), Uint64.class);
        return executeRemoteCall(function, Uint64.class);
    }

    public static RemoteCall<InnerFunction> deploy(Web3j web3j, Credentials credentials, GasProvider contractGasProvider) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(InnerFunction.class, web3j, credentials, contractGasProvider, encodedConstructor);
    }

    public static RemoteCall<InnerFunction> deploy(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(InnerFunction.class, web3j, transactionManager, contractGasProvider, encodedConstructor);
    }

    public static RemoteCall<InnerFunction> deploy(Web3j web3j, Credentials credentials, GasProvider contractGasProvider, BigInteger initialVonValue) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(InnerFunction.class, web3j, credentials, contractGasProvider, encodedConstructor, initialVonValue);
    }

    public static RemoteCall<InnerFunction> deploy(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, BigInteger initialVonValue) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(InnerFunction.class, web3j, transactionManager, contractGasProvider, encodedConstructor, initialVonValue);
    }

    public static InnerFunction load(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider) {
        return new InnerFunction(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static InnerFunction load(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider) {
        return new InnerFunction(contractAddress, web3j, transactionManager, contractGasProvider);
    }
}
