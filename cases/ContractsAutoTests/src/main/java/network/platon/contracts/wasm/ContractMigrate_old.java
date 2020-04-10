package network.platon.contracts.wasm;

import com.platon.rlp.datatypes.Uint64;
import com.platon.rlp.datatypes.Uint8;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.web3j.abi.WasmEventEncoder;
import org.web3j.abi.WasmFunctionEncoder;
import org.web3j.abi.datatypes.WasmEvent;
import org.web3j.abi.datatypes.WasmEventParameter;
import org.web3j.abi.datatypes.WasmFunction;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.PlatonFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.WasmContract;
import org.web3j.tx.gas.GasProvider;
import rx.Observable;
import rx.functions.Func1;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://github.com/PlatONnetwork/client-sdk-java/releases">platon-web3j command line tools</a>,
 * or the org.web3j.codegen.WasmFunctionWrapperGenerator in the 
 * <a href="https://github.com/PlatONnetwork/client-sdk-java/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with platon-web3j version 0.9.1.2-SNAPSHOT.
 */
public class ContractMigrate_old extends WasmContract {
    private static String BINARY_0 = "0x0061736d0100000001691160027f7f0060017f017f60017f0060037f7f7f0060000060027f7f017f60047f7f7f7f0060037f7f7f017f60027f7e0060047f7f7f7f017f60017f017e60077f7f7f7f7f7f7f0060047f7f7e7e0060037f7e7f006000017f60077f7f7f7f7f7f7f017f60017e017f02e3010a03656e760c706c61746f6e5f70616e6963000403656e760c706c61746f6e5f6576656e74000603656e760e706c61746f6e5f6d696772617465000f03656e7617706c61746f6e5f6765745f696e7075745f6c656e677468000e03656e7610706c61746f6e5f6765745f696e707574000203656e760d706c61746f6e5f72657475726e000003656e760b706c61746f6e5f73686133000603656e7617706c61746f6e5f6765745f73746174655f6c656e677468000503656e7610706c61746f6e5f6765745f7374617465000903656e7610706c61746f6e5f7365745f7374617465000603686704070704010101070404050303020b03050600020402020701010101060003010201030300000100000000000200000003030008100d05090003000200050200050000010000020002000c080004070a0a000000000101020100010002000808010000010009020405017001050505030100020615037f0141908b040b7f0041908b040b7f0041820b0b075406066d656d6f72790200115f5f7761736d5f63616c6c5f63746f7273000a0b5f5f686561705f6261736503010a5f5f646174615f656e6403020f5f5f66756e63735f6f6e5f65786974001e06696e766f6b650057090a010041010b04205353450adc75673600100d41a40a420037020041ac0a410036020041a40a101d4101101f41b00a420037020041b80a410036020041b00a101d4104101f0ba20a010d7f2002410f6a210f410020026b21072002410e6a210a410120026b210e2002410d6a210d410220026b210c0340200020056a2103200120056a220441037145200220054672450440200320042d00003a0000200f417f6a210f200741016a2107200a417f6a210a200e41016a210e200d417f6a210d200c41016a210c200541016a21050c010b0b200220056b210602400240024002402003410371220b044020064120490d03200b4101460d01200b4102460d02200b4103470d032003200120056a280200220a3a0000200041016a210b200220056b417f6a210c200521030340200c4113494504402003200b6a2208200120036a220941046a2802002206411874200a41087672360200200841046a200941086a2802002204411874200641087672360200200841086a2009410c6a28020022064118742004410876723602002008410c6a200941106a280200220a411874200641087672360200200341106a2103200c41706a210c0c010b0b2002417f6a2007416d2007416d4b1b200f6a4170716b20056b2106200120036a41016a2104200020036a41016a21030c030b2006210403402004411049450440200020056a2203200120056a2202290200370200200341086a200241086a290200370200200541106a2105200441706a21040c010b0b027f2006410871450440200120056a2104200020056a0c010b200020056a2202200120056a2201290200370200200141086a2104200241086a0b21052006410471044020052004280200360200200441046a2104200541046a21050b20064102710440200520042f00003b0000200441026a2104200541026a21050b2006410171450d03200520042d00003a000020000f0b2003200120056a2206280200220a3a0000200341016a200641016a2f00003b0000200041036a210b200220056b417d6a210720052103034020074111494504402003200b6a2208200120036a220941046a2802002206410874200a41187672360200200841046a200941086a2802002204410874200641187672360200200841086a2009410c6a28020022064108742004411876723602002008410c6a200941106a280200220a410874200641187672360200200341106a2103200741706a21070c010b0b2002417d6a200c416f200c416f4b1b200d6a4170716b20056b2106200120036a41036a2104200020036a41036a21030c010b2003200120056a2206280200220d3a0000200341016a200641016a2d00003a0000200041026a210b200220056b417e6a210720052103034020074112494504402003200b6a2208200120036a220941046a2802002206411074200d41107672360200200841046a200941086a2802002204411074200641107672360200200841086a2009410c6a28020022064110742004411076723602002008410c6a200941106a280200220d411074200641107672360200200341106a2103200741706a21070c010b0b2002417e6a200e416e200e416e4b1b200a6a4170716b20056b2106200120036a41026a2104200020036a41026a21030b20064110710440200320042d00003a00002003200428000136000120032004290005370005200320042f000d3b000d200320042d000f3a000f200441106a2104200341106a21030b2006410871044020032004290000370000200441086a2104200341086a21030b2006410471044020032004280000360000200441046a2104200341046a21030b20064102710440200320042f00003b0000200441026a2104200341026a21030b2006410171450d00200320042d00003a00000b20000bfc0202027f017e02402002450d00200020013a0000200020026a2203417f6a20013a000020024103490d00200020013a0002200020013a00012003417d6a20013a00002003417e6a20013a000020024107490d00200020013a00032003417c6a20013a000020024109490d002000410020006b41037122046a2203200141ff017141818284086c22013602002003200220046b417c7122046a2202417c6a200136020020044109490d002003200136020820032001360204200241786a2001360200200241746a200136020020044119490d002003200136021820032001360214200320013602102003200136020c200241706a20013602002002416c6a2001360200200241686a2001360200200241646a20013602002001ad220542208620058421052004200341047141187222016b2102200120036a2101034020024120490d0120012005370300200141186a2005370300200141106a2005370300200141086a2005370300200141206a2101200241606a21020c000b000b20000b3501017f230041106b220041908b0436020c418408200028020c41076a41787122003602004180082000360200418c083f003602000b9f0101047f230041106b220224002002200036020c027f02400240024020000440418c08200041086a22014110762200418c082802006a2203360200418408200141840828020022016a41076a4178712204360200200341107420044d0d0120000d020c030b41000c030b418c08200341016a360200200041016a21000b200040000d0010000b20012002410c6a4104100b1a200141086a0b200241106a24000b2f01027f2000410120001b2100034002402000100e22010d004190082802002202450d0020021104000c010b0b20010b7801027f20002101024003402001410371044020012d0000450d02200141016a21010c010b0b2001417c6a21010340200141046a22012802002202417f73200241fffdfb776a7141808182847871450d000b0340200241ff0171450d01200141016a2d00002102200141016a21010c000b000b200120006b0bc10301067f024020002001460d00027f02400240200120006b20026b410020024101746b4b044020002001734103712103200020014f0d012003450d0220000c030b200020012002100b0f0b024020030d002001417f6a21030340200020026a220441037104402002450d052004417f6a200220036a2d00003a00002002417f6a21020c010b0b2000417c6a21032001417c6a2104034020024104490d01200220036a200220046a2802003602002002417c6a21020c000b000b2001417f6a210103402002450d03200020026a417f6a200120026a2d00003a00002002417f6a21020c000b000b200241046a21062002417f73210503400240200120046a2107200020046a2208410371450d0020022004460d03200820072d00003a00002006417f6a2106200541016a2105200441016a21040c010b0b200220046b21014100210303402001410449450440200320086a200320076a280200360200200341046a21032001417c6a21010c010b0b200320076a210120022005417c2005417c4b1b20066a417c716b20046b2102200320086a0b210303402002450d01200320012d00003a00002002417f6a2102200341016a2103200141016a21010c000b000b20000b0a0041940841013602000b0a0041940841003602000b4d01017f20004200370200200041086a2202410036020020012d0000410171450440200020012902003702002002200141086a28020036020020000f0b200020012802082001280204101520000b6401027f2002417049044002402002410a4d0440200020024101743a0000200041016a21030c010b200241106a4170712204100f21032000200236020420002004410172360200200020033602080b2003200120021016200220036a41003a00000f0b000b13002002047f200020012002100b0520000b1a0b130020002d0000410171044020002802081a0b0bb70101027f416e20016b20024f0440027f200041016a20002d0000410171450d001a20002802080b2108027f416f200141e6ffffff074b0d001a410b20014101742207200120026a220220022007491b2202410b490d001a200241106a4170710b2207100f21022005044020022006200510160b200320046b220322060440200220056a200420086a200610160b200020023602082000200320056a220136020420002007410172360200200120026a41003a00000f0b000b13002002047f20002001200210110520000b1a0bf40101037f027f20002d00002203410171220445044020034101760c010b20002802040b220341004f0440410a2102027f02400240200404402000280200417e71417f6a21020b200220036b200149044020002002200120036a20026b20034100200141ed0a10180c010b2001450d0020040d01200041016a0c020b20000f0b20002802080b22022003047f200120026a200220031019200141ed0a6a41ed0a200220036a41ed0a4b1b41ed0a200241ed0a4d1b0541ed0a0b20011019200120036a2101024020002d0000410171450440200020014101743a00000c010b200020013602040b200120026a41003a000020000f0b000be30201057f027f20002d00002205410171220445044020054101760c010b20002802040b220641004f04402006200120062001491b2101410a2105200404402000280200417e71417f6a21050b200120066b20056a200349044020002005200320066a20016b20056b200620012003200210180f0b2004047f200028020805200041016a0b21040240024020012003460440200321010c010b200620016b2207450d00200120034b04402004200220031019200320046a200120046a200710190c020b0240200420066a20024d200420024f720d00200120046a20024b04402004200220011019200320016b200220036a2102200121084100210121030c010b2002200320016b6a21020b200420086a220520036a200120056a200710190b200420086a2002200310190b200320016b20066a2101024020002d0000410171450440200020014101743a00000c010b200020013602040b200120046a41003a00000f0b000b6d01027f2001417049044002402001410a4d0440200020014101743a0000200041016a21020c010b200141106a4170712203100f21022000200136020420002003410172360200200020023602080b2001047f200241302001100c0520020b1a200120026a41003a00000f0b000b2301017f03402001410c46450440200020016a4100360200200141046a21010c010b0b0b7601037f101241980828020021000340200004400340419c08419c082802002201417f6a22023602002001410148450440200020024102746a22004184016a280200200041046a2802001013110200101241980828020021000c010b0b419c084120360200419808200028020022003602000c010b0b0b960101027f1012419808280200220145044041980841a00836020041a00821010b0240419c0828020022024120460440418402100e2201044020014100418402100c1a0b2001450d0120014198082802003602004198082001360200419c084100360200410021020b419c08200241016a360200200120024102746a22014184016a4100360200200141046a200036020010130f0b10130b070041a40a10170b780020004200370210200042ffffffff0f3702082000200129020037020002402002410871450d002000102220012802044f0d002002410471450440200042003702000c010b10000b024002402002411071450d002000102220012802044d0d0020024104710d01200042003702000b20000f0b100020000b290002402000280204044020002802002c0000417f4c0d0141010f0b41000f0b20001023200010246a0b240002402000280204450d0020002802002c0000417f4c0d0041000f0b2000102941016a0b8a0301047f02400240200028020404402000102a4101210220002802002c00002201417f4c0d010c020b41000f0b200141ff0171220241b7014d0440200241807f6a0f0b02400240200141ff0171220141bf014d04400240200041046a22042802002201200241c97e6a22034d047f100020042802000520010b4102490d0020002802002d00010d0010000b200341054f044010000b20002802002d000145044010000b410021024100210103402001200346450440200028020020016a41016a2d00002002410874722102200141016a21010c010b0b200241384f0d010c020b200141f7014d0440200241c07e6a0f0b0240200041046a22042802002201200241897e6a22034d047f100020042802000520010b4102490d0020002802002d00010d0010000b200341054f044010000b20002802002d000145044010000b410021024100210103402001200346450440200028020020016a41016a2d00002002410874722102200141016a21010c010b0b20024138490d010b200241ff7d490d010b100020020f0b20020b3902017f017e230041306b2201240020012000290200220237031020012002370308200141186a200141086a411410211022200141306a24000b5e01027f2000027f027f2001280200220504404100200220036a200128020422014b2001200249720d011a410020012003490d021a200220056a2104200120026b20032003417f461b0c020b41000b210441000b360204200020043602000b2101017f20011024220220012802044b044010000b2000200120011023200210260b900302097f017e230041406a220324002001280208220520024b0440200341386a20011027200320032903383703182001200341186a102536020c200341306a20011027410021052001027f410020032802302206450d001a410020032802342208200128020c2207490d001a200820072007417f461b210420060b360210200141146a2004360200200141086a41003602000b200141106a2109200141146a21072001410c6a2106200141086a210803400240200520024f0d002007280200450d00200341306a2001102741002105027f2003280230220a044041002003280234220b20062802002204490d011a200b20046b21052004200a6a0c010b41000b210420072005360200200920043602002003200536022c2003200436022820032003290328370310200341306a20094100200341106a1025102620092003290330220c37020020062006280200200c422088a76a3602002008200828020041016a22053602000c010b0b20032009290200220c3703202003200c3703082000200341086a411410211a200341406b24000b4101017f02402000280204450d0020002802002d0000220041bf014d0440200041b801490d01200041c97e6a0f0b200041f801490d00200041897e6a21010b20010b4401017f200028020445044010000b0240200028020022012d0000418101470d00200041046a28020041014d047f100020002802000520010b2c00014100480d0010000b0b9f0101037f0240200028020404402000102a200028020022022c000022014100480d0120014100470f0b41000f0b027f4101200141807f460d001a200141ff0171220341b7014d0440200041046a28020041014d047f100020002802000520020b2d00014100470f0b4100200341bf014b0d001a200041046a280200200141ff017141ca7e6a22014d047f100020002802000520020b20016a2d00004100470b0b1d01017f200020012802002203200320012802046a102d20002002102e0b2c002000200220016b2202102f200028020020002802046a20012002100b1a2000200028020420026a3602040b9e0201077f02402001450d002000410c6a2107200041106a2105200041046a21060340200528020022022007280200460d01200241786a28020020014904401000200528020021020b200241786a2203200328020020016b220136020020010d01200520033602002000410120062802002002417c6a28020022016b22021030220341016a20024138491b2204200628020022086a10312004200120002802006a22046a2004200820016b10111a0240200241374d0440200028020020016a200241406a3a00000c010b200341f7016a220441ff014d0440200028020020016a20043a00002000280200200120036a6a210103402002450d02200120023a0000200241087621022001417f6a21010c000b000b10000b410121010c000b000b0b1b00200028020420016a220120002802084b04402000200110320b0b1e01017f03402000044020004108762100200141016a21010c010b0b20010b0f00200020011032200020013602040b3901017f200028020820014904402001100e220220002802002000280204100b1a20002802001a200041086a2001360200200020023602000b0b5001017f230041106b2202240002402001044020022001360200200220002802043602042000410c6a200210340c010b2002410036020820024200370300200020021035200210360b200241106a24000b3701017f20002802042202200028020849044020022001290200370200200041046a2200200028020041086a3602000f0b2000200110370b3d01027f230041106b220224002002200128020022033602082002200128020420036b36020c20022002290308370300200020021038200241106a24000b1501017f200028020022010440200020013602040b0b7201027f230041206b22032400200341086a2000200028020420002802006b41037541016a1040200028020420002802006b410375200041086a1041220228020820012902003702002002200228020841086a36020820002002104220022002280204104420022802001a200341206a24000b5902027f017e230041106b2202240002402001280204220341374d04402000200341406a41ff017110390c010b2000200341f701103a0b20022001290200220437030820022004370300200020024101102c200241106a24000b250020004101102f200028020020002802046a20013a00002000200028020441016a3602040b2a01017f20022001103022026a22034180024e044010000b2000200341ff01711039200020012002103b0b3d002000200028020420026a1031200028020020002802046a417f6a2100034020010440200020013a0000200141087621012000417f6a21000c010b0b0b920101037f230041106b2202240020012802002103024002400240024020012802042201410146044020032c000022044100480d012000200441ff017110390c040b200141374b0d010b200020014180017341ff017110390c010b2000200141b701103a0b2002200136020c2002200336020820022002290308370300200020024100102c0b20004101102e200241106a24000b830101037f02400240200150450440200142ff00560d0120002001a741ff017110390c020b200041800110390c010b02402001103e220241374d0440200020024180017341ff017110390c010b20021030220341b7016a22044180024f044010000b2000200441ff01711039200020022003103b0b200020012002103f0b20004101102e0b3202017f017e034020002002845045044020024238862000420888842100200141016a2101200242088821020c010b0b20010b5101017e2000200028020420026a1031200028020020002802046a417f6a21000340200120038450450440200020013c0000200342388620014208888421012000417f6a2100200342088821030c010b0b0b40002001418080808002490440200028020820002802006b220041037541feffffff004d047f20012000410275220020002001491b0541ffffffff010b0f0b000b6401017f2000410036020c200041106a200336020020010440027f20014180808080024904402001410374100f0c010b000b21040b200020043602002000200420024103746a22023602082000410c6a200420014103746a3602002000200236020420000b6701017f20002802002000280204200141046a1043200028020021022000200128020436020020012002360204200028020421022000200128020836020420012002360208200028020821022000200128020c3602082001200236020c200120012802043602000b270020022002280200200120006b22016b2202360200200141014e0440200220002001100b1a0b0b2c01017f20002802082102200041086a2100034020012002464504402000200241786a22023602000c010b0b0b070041b00a10170bc10301067f230041c0016b22022400200241bc0a10472104200241e8006a1048200241fc006a410036020020024200370274200241e8006a41021033200241d8006a20041049200241c8006a20001049200241406b4100360200200241386a4200370300200241306a420037030020024200370328200241286a200241d8006a104a200241c8006a104a200241e8006a2002280228104b200241e8006a200241d8006a104c200241e8006a200241c8006a104c2002280274200241f8006a28020047044010000b200228026c21062002280268200241106a104d210020024180016a200110142101200241a8016a4100360200200241a0016a420037030020024198016a4200370300200242003703900120024190016a4100104e20024190016a200241b0016a200110142203104f2003101720024190016a4101104e200228029001210320024190016a410472105020002003104b200041011033200020024190016a20011014220310512003101720011017200028020c200041106a28020047044010000b20062000280200200028020410012000105241046a1050200241c8006a1036200241d8006a1036200241e8006a105220041017200241c0016a24000b1f0020004200370200200041086a41003602002000200120011010101520000b160020004100360208200042003702002000410010670b800101037f230041306b22032400200341186a104d220220011060104b2002200341086a200110142201105120011017200228020c200241106a28020047044010000b2000410036020820004200370200200228020421012002280200200041201065200120002802002201200028020420016b100620021052200341306a24000b880101027f0240024002400240200128020022032001280204220147044041012102200120036b22014101470d0120032c0000417f4a0d040c020b410121020c030b200141374b0d010b200141016a21020c010b2001103020016a41016a21020b027f200041186a2802000440200041046a106a0c010b20000b2201200128020020026a36020020000b1300200028020820014904402000200110670b0b3d01027f230041106b220224002002200128020022033602082002200128020420036b36020c2002200229030837030020002002103c200241106a24000b190020001048200041146a41003602002000420037020c20000bed0e020b7f027e230041306b22062400200041046a21090240200141014604402009106a2802002101200041186a22022002280200417f6a3602002009106d4180104f04402000410c6a2202280200417c6a2802001a20092002280200417c6a106c0b200141384f047f2001103020016a0520010b41016a2101200041186a280200450d012009106a21000c010b02402009106d0d00200041146a220128020022024180084f0440200120024180786a360200200041086a2201280200220228020021042001200241046a360200200620043602182009200641186a106e0c010b024002400240024002400240024002402000410c6a2802002202200041086a2802006b4102752204200041106a2203280200220520002802046b2201410275490440418020100f210820022005470d01200041086a22042802002202200041046a2802002205460d02200221010c080b20062001410175410120011b20042003106f2104418020100f210820042802082201200428020c2205470d0320042802042202200428020022034d0d02200120026b220141027521052002200220036b41027541016a417e6d41027422076a2103200441046a2001047f20032002200110111a200441046a2802000520020b20076a360200200441086a200320054102746a22013602000c030b2000410c6a22042802002201200041106a2802002205470d04200041086a22072802002202200041046a28020022034d0d03200120026b220141027521052002200220036b41027541016a417e6d41027422076a2103200041086a2001047f20032002200110111a200041086a2802000520020b20076a3602002000410c6a200320054102746a22013602000c040b2000410c6a22072802002203200041106a220a28020022014f0d042003200120036b41027541016a41026d41027422076a2101200320026b22050440200120056b22012002200510111a2000410c6a28020021030b200041086a20013602002000410c6a200320076a3602000c050b200641186a200520036b2201410175410120011b22012001410276200441106a280200106f2102200441086a2802002105200441046a2802002101034020012005470440200241086a220328020020012802003602002003200328020041046a360200200141046a21010c010b0b2004290200210d200420022902003702002002200d370200200441086a2201290200210d2001200241086a22032902003702002003200d37020020021070200128020021010b20012008360200200441086a2208200828020041046a3602002000410c6a2802002105200441106a210b0340200041086a28020020054704402005417c6a21050240200441046a220728020022022004280200220a470440200221010c010b200828020022032004410c6a28020022014904402003200120036b41027541016a41026d410274220c6a2101200320026b220a04402001200a6b22012002200a10111a200828020021030b2007200136020020082003200c6a3602000c010b200641186a2001200a6b2201410175410120011b2201200141036a410276200b280200106f2008280200210a2007280200210103402001200a470440200641206a220228020020012802003602002002200228020041046a360200200141046a21010c010b0b2004290200210d200420062903183702002008290200210e2008200641206a22012903003702002001200e3703002006200d3703181070200728020021010b2001417c6a200528020036020020072007280200417c6a3602000c010b0b200041046a220128020021022001200428020036020020042002360200200441046a2201280200210220012005360200200041086a20023602002000410c6a2201290200210d2001200441086a22012902003702002001200d370200200410700c040b200641186a200520036b2201410175410120011b22012001410276200041106a106f21022000410c6a280200210520072802002101034020012005470440200241086a220328020020012802003602002003200328020041046a360200200141046a21010c010b0b200041046a2201290200210d200120022902003702002002200d3702002000410c6a2201290200210d2001200241086a22032902003702002003200d37020020021070200128020021010b200120083602002004200428020041046a3602000c020b200641186a200120056b2201410175410120011b2201200141036a410276200a106f210220072802002105200041086a2802002101034020012005470440200241086a220328020020012802003602002003200328020041046a360200200141046a21010c010b0b200041046a2201290200210d200120022902003702002002200d3702002000410c6a2201290200210d2001200241086a22012902003702002001200d37020020021070200041086a28020021010b2001417c6a2008360200200420042802002201417c6a22023602002002280200210220042001360200200620023602182009200641186a106e0b200641186a2009106b200628021c4100360200200041186a2100410121010b2000200028020020016a360200200641306a24000b890101037f410121030240200128020420012d00002202410176200241017122041b2202450d0002400240200241014604402001280208200141016a20041b2c0000417f4a0d030c010b200241374b0d010b200241016a21030c010b2002103020026a41016a21030b200041186a2802000440200041046a106a21000b2000200028020020036a3602000ba90201067f230041106b22042400200028020422012000280210220341087641fcffff07716a2102027f200120002802084704402002280200200341ff07714102746a0c010b41000b2101200441086a2000106b200428020c2103034020012003470440200141046a220120022802006b418020470d0120022802042101200241046a21020c010b0b20004100360214200041046a22022802002101200041086a210503402005280200220620016b410275220341034f044020012802001a2002200228020041046a22013602000c010b0b0240200041106a027f2003410147044020034102470d024180080c010b4180040b3602000b03402001200647044020012802001a200141046a21010c010b0b2000200041046a280200106c20002802001a200441106a24000b5201037f230041106b2202240020022001280208200141016a20012d0000220341017122041b36020820022001280204200341017620041b36020c2002200229030837030020002002103c200241106a24000b1c01017f200028020c22010440200041106a20013602000b200010660b0900200020013a00100bc70101027f230041d0006b22042400034020054114470440200441186a20056a41003a0000200541016a21050c010b0b200441406b20021055200441306a20031055200441186a20012802002205200128020420056b20042802402201200428024420016b20042802302201200428023420016b10021a200441306a1036200441406b1036200441406b200441186a1056200441086a200441186a1056200441406b200441086a1046200441086a1017200441406b10172000200441186a1056200441d0006a24000b6302017f017e20012103034020035045044020034208882103200241016a21020c010b0b20004100360208200042003702002000200210652000280204417f6a21020340200150450440200220013c00002002417f6a2102200142088821010c010b0b0bb70201077f230041206b22022400200241106a41f00a10472105200241086a4100360200200242003703002002200528020420022d0010220341017620034101711b220341286a101c027f20022d00102204410171450440200541016a210620044101760c010b20052802082106200541046a2802000b2107410021042002200320062007101b20024101722106200241086a21070340200441144704402007280200200620022d00004101711b20036a200120046a22082d000041047641f10a6a2d00003a00002007280200200620022d00004101711b20036a41016a20082d0000410f7141f10a6a2d00003a0000200441016a2104200341026a21030c010b0b200510172000200241ed0a1010101a2201290200370200200041086a200141086a2802003602002001101d20021017200241206a24000beb0602057f017e230041c0016b22002400100a10032201100e22021004200041d0006a200041206a20022001105822014100102802400240200041d0006a10592205500d0041c50a105a20055104402000410036021c200041023602182000200029031837030020012000105b0c020b02400240024041ca0a105a2005510440200041e8006a420037030020004100360258200042003703502000420037036020004101360274200020013602782000200041f4006a36027c200041a8016a200141011028200041e0006a210320002802ac01450d0120002802a8012d000041c0014f0d0120004198016a200041a8016a105c200028029801210220004188016a200041a8016a105c2000280288012101200041a8016a1024210420004100360240200042003703380240200120046a20026b2201450d00200041386a2001105d20014101480d00200028023c20022001100b1a2000200028023c20016a36023c0b20002802502201450d0220002001360254200041d8006a4100360200200042003703500c020b41db0a105a2005520d022000410036021420004103360210200020002903103703082001200041086a105b0c040b20004100360240200042003703380b20002000280238360250200029023c2105200041003602402000200537025420004200370338200041386a10362000200028027441016a360274200041f8006a2003105e200041f8006a200041e8006a2202105e200041386a105f2000410036028001200042003703780240200028025420002802506b2201450d00200041f8006a2001105d2000280254200028025022046b22014101480d00200028027c20042001100b1a2000200028027c20016a36027c0b20004188016a200041f8006a200041e0006a29030020022903001054200041a8016a104d220120004188016a1060104b200120004198016a20004188016a10142202105120021017200128020c200141106a28020047044010000b2001280200200128020410052001105220004188016a1017200041f8006a10361061200041d0006a10360c020b41e40a105a2005520d00200041a8016a105f200020002d00b80122033a0038200041d0006a104d2201200041386a1062104b200120031063200128020c200141106a28020047044010000b2001280200200128020410052001105210610c010b10000b200041c0016a24000b3401017f230041106b220324002003200236020c200320013602082003200329030837030020002003411c1021200341106a24000b850102027f017e230041106b220124002000102a024002402000102b450d002000280204450d0020002802002d000041c001490d010b10000b200141086a2000105c200128020c220041094f044010000b200128020821020340200004402000417f6a210020023100002003420886842103200241016a21020c010b0b200141106a240020030b3901027e42a5c688a1c89ca7f94b210103402000300000220250450440200041016a2100200142b383808080207e20028521010c010b0b20010b6701047f230041206b220224002001280200210320012802042101200241086a200041011028200241086a10642104200241086a105f200241086a20014101756a220020042001410171047f200028020020036a2802000520030b1100001061200241206a24000be60101047f200110242204200128020422024b04401000200141046a28020021020b200128020021052000027f024002400240027f0240200204404100210120052c00002203417f4c0d012005450d030c040b41000c010b200341ff0171220141bf014d04404100200341ff017141b801490d011a200141c97e6a0c010b4100200341ff017141f801490d001a200141897e6a0b41016a210120050d010b410021030c010b410021032002200149200120046a20024b720d00410020022004490d011a200120056a2103200220016b20042004417f461b0c010b41000b360204200020033602000b2a01017f2001417f4a044020002001100f2202360200200020023602042000200120026a3602080f0b000b4601017f230041206b22022400200241086a2000280200200028020428020010282001200241086a105937030020002802042200200028020041016a360200200241206a24000bdc0101067f230041406a22012400200042e4e9dbd7f9a5b1f1e000370308200041003a0000200141286a104d220320002903081068200328020c200341106a28020047044010000b20032802002204200328020422061007220504402001410036022020014200370318200141186a200510652004200620012802182204200128021c20046b1008417f470440200041106a20012001280218220241016a200128021c2002417f736a105810643a0000200521020b200141186a10360b200310522002450440200041106a20002d00003a00000b200141406b240020000b5b01017f230041306b22012400200141286a4100360200200141206a4200370300200141186a420037030020014200370310200141106a2001200010142200104f200010172001280210200141106a4104721050200141306a24000ba903010a7f230041d0006b22012400200141186a104d2104200141c8006a4100360200200141406b4200370300200141386a420037030020014200370330200141306a2000290308106920012802302102200141306a410472105020042002104b200420002903081068200428020c200441106a28020047044010000b200428020421062004280200200141306a104d2102200041106a2208106221094101100f220041fe013a0000200120003602082001200041016a22033602102001200336020c200228020c200241106a2802004704401000200128020c2103200128020821000b200320006b2203200228020422056a220a20022802084b047f2002200a1067200241046a2802000520050b20022802006a20002003100b1a200241046a2200200028020020036a3602002002200128020c20096a20012802086b104b200220082d0000106302402002410c6a2203280200200241106a220528020047044010002002280200210020032802002005280200460d0110000c010b200228020021000b20062000200241046a2802001009200141086a10362002105220041052200141d0006a24000b4e01017f230041206b22012400200141186a4100360200200141106a4200370300200141086a420037030020014200370300200120003100001069200128020020014104721050200141206a24000b090020002001ad103d0b7d01037f230041106b220124002000102a024002402000102b450d002000280204450d0020002802002d000041c001490d010b10000b200141086a2000105c200128020c220041024f044010000b200128020821020340200004402000417f6a210020022d00002103200241016a21020c010b0b200141106a240020030b8f0201067f0240024002400240024020002802042202200028020022046b220320014904402000280208220620026b200120036b22074f0d012001417f4c0d0341ffffffff072105200620046b220241feffffff034d044020012002410174220220022001491b2205450d030b2005100f21020c040b200320014d0d04200041046a200120046a3602000f0b200320016b2101200041046a21000340200241003a00002000200028020041016a2202360200200141016a22010d000b0c030b41002105410021020c010b000b200220036a41002007100c1a200341014e0440200220042003100b1a0b20002002360200200041086a200220056a360200200041046a200120026a3602002004450d000b0b080020002802001a0b3601017f200028020820014904402001100e20002802002000280204100b210220001066200041086a2001360200200020023602000b0b080020002001103d0b7502027f017e4101210320014280015a0440034020012004845045044020044238862001420888842101200241016a2102200442088821040c010b0b200241384f047f2002103020026a0520020b41016a21030b200041186a2802000440200041046a106a21000b2000200028020020036a3602000b2e002000280204200028021420002802106a417f6a220041087641fcffff07716a280200200041ff07714102746a0b5101037f20012802042203200128021020012802146a220441087641fcffff07716a21022000027f200320012802084704402002280200200441ff07714102746a0c010b41000b360204200020023602000b2c01017f20002802082102200041086a21000340200120024645044020002002417c6a22023602000c010b0b0b2801017f200028020820002802046b2201410874417f6a410020011b200028021420002802106a6b0be50202067f017e230041206b22062400024020002802082202200028020c2205470d0020002802042203200028020022044b0440200220036b220241027521052003200320046b41027541016a417e6d41027422076a2104200041046a2002047f20042003200210111a200041046a2802000520030b20076a360200200041086a200420054102746a22023602000c010b200641086a200520046b2202410175410120021b220220024102762000410c6a106f2103200041086a2802002105200041046a280200210203402002200546450440200341086a220428020020022802003602002004200428020041046a360200200241046a21020c010b0b200029020021082000200329020037020020032008370200200041086a220229020021082002200341086a22042902003702002004200837020020031070200228020021020b20022001280200360200200041086a2200200028020041046a360200200641206a24000b6201017f2000410036020c200041106a200336020002402001044020014180808080044f0d012001410274100f21040b200020043602002000200420024102746a22023602082000410c6a200420014102746a3602002000200236020420000f0b000b3801037f2000280208210120002802042102200041086a210303402001200247044020032001417c6a22013602000c010b0b20002802001a0b0b4c010041bc0a0b457472616e7366657200696e6974006d6967726174655f636f6e74726163740073657455696e74380067657455696e7438003078000030313233343536373839616263646566";

    public static String BINARY = BINARY_0;

    public static final String FUNC_MIGRATE_CONTRACT = "migrate_contract";

    public static final String FUNC_SETUINT8 = "setUint8";

    public static final String FUNC_GETUINT8 = "getUint8";

    public static final WasmEvent TRANSFER_EVENT = new WasmEvent("transfer", Arrays.asList(new WasmEventParameter(String.class, true)), Arrays.asList(new WasmEventParameter(String.class)));
    ;

    protected ContractMigrate_old(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    protected ContractMigrate_old(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<ContractMigrate_old> deploy(Web3j web3j, Credentials credentials, GasProvider contractGasProvider, Uint8 input) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList(input));
        return deployRemoteCall(ContractMigrate_old.class, web3j, credentials, contractGasProvider, encodedConstructor);
    }

    public static RemoteCall<ContractMigrate_old> deploy(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, Uint8 input) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList(input));
        return deployRemoteCall(ContractMigrate_old.class, web3j, transactionManager, contractGasProvider, encodedConstructor);
    }

    public static RemoteCall<ContractMigrate_old> deploy(Web3j web3j, Credentials credentials, GasProvider contractGasProvider, BigInteger initialVonValue, Uint8 input) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList(input));
        return deployRemoteCall(ContractMigrate_old.class, web3j, credentials, contractGasProvider, encodedConstructor, initialVonValue);
    }

    public static RemoteCall<ContractMigrate_old> deploy(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, BigInteger initialVonValue, Uint8 input) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList(input));
        return deployRemoteCall(ContractMigrate_old.class, web3j, transactionManager, contractGasProvider, encodedConstructor, initialVonValue);
    }

    public RemoteCall<TransactionReceipt> migrate_contract(byte[] init_arg, Uint64 transfer_value, Uint64 gas_value) {
        final WasmFunction function = new WasmFunction(FUNC_MIGRATE_CONTRACT, Arrays.asList(init_arg,transfer_value,gas_value), Void.class);
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> migrate_contract(byte[] init_arg, Uint64 transfer_value, Uint64 gas_value, BigInteger vonValue) {
        final WasmFunction function = new WasmFunction(FUNC_MIGRATE_CONTRACT, Arrays.asList(init_arg,transfer_value,gas_value), Void.class);
        return executeRemoteCallTransaction(function, vonValue);
    }

    public RemoteCall<TransactionReceipt> setUint8(Uint8 input) {
        final WasmFunction function = new WasmFunction(FUNC_SETUINT8, Arrays.asList(input), Void.class);
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> setUint8(Uint8 input, BigInteger vonValue) {
        final WasmFunction function = new WasmFunction(FUNC_SETUINT8, Arrays.asList(input), Void.class);
        return executeRemoteCallTransaction(function, vonValue);
    }

    public RemoteCall<Uint8> getUint8() {
        final WasmFunction function = new WasmFunction(FUNC_GETUINT8, Arrays.asList(), Uint8.class);
        return executeRemoteCall(function, Uint8.class);
    }

    public List<TransferEventResponse> getTransferEvents(TransactionReceipt transactionReceipt) {
        List<WasmContract.WasmEventValuesWithLog> valueList = extractEventParametersWithLog(TRANSFER_EVENT, transactionReceipt);
        ArrayList<TransferEventResponse> responses = new ArrayList<TransferEventResponse>(valueList.size());
        for (WasmContract.WasmEventValuesWithLog eventValues : valueList) {
            TransferEventResponse typedResponse = new TransferEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.topic = (String) eventValues.getIndexedValues().get(0);
            typedResponse.arg1 = (String) eventValues.getNonIndexedValues().get(0);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<TransferEventResponse> transferEventObservable(PlatonFilter filter) {
        return web3j.platonLogObservable(filter).map(new Func1<Log, TransferEventResponse>() {
            @Override
            public TransferEventResponse call(Log log) {
                WasmContract.WasmEventValuesWithLog eventValues = extractEventParametersWithLog(TRANSFER_EVENT, log);
                TransferEventResponse typedResponse = new TransferEventResponse();
                typedResponse.log = log;
                typedResponse.topic = (String) eventValues.getIndexedValues().get(0);
                typedResponse.arg1 = (String) eventValues.getNonIndexedValues().get(0);
                return typedResponse;
            }
        });
    }

    public Observable<TransferEventResponse> transferEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        PlatonFilter filter = new PlatonFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(WasmEventEncoder.encode(TRANSFER_EVENT));
        return transferEventObservable(filter);
    }

    public static ContractMigrate_old load(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider) {
        return new ContractMigrate_old(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ContractMigrate_old load(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider) {
        return new ContractMigrate_old(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static class TransferEventResponse {
        public Log log;

        public String topic;

        public String arg1;
    }
}
