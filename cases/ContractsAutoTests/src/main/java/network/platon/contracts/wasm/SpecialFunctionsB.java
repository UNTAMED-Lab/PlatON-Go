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
 * <p>Generated with platon-web3j version 0.13.1.5.
 */
public class SpecialFunctionsB extends WasmContract {
    private static String BINARY_0 = "0x0061736d01000000014c0e60017f017f60017f0060027f7f0060000060017f017e60037f7f7f0060037f7e7e0060027f7f017f6000017e60037e7e7f006000017f60037f7f7f017f60047f7f7f7f017f60027e7e017f029c020d03656e760c706c61746f6e5f70616e6963000303656e7610706c61746f6e5f6761735f7072696365000003656e760a706c61746f6e5f676173000803656e7610706c61746f6e5f6761735f6c696d6974000803656e760d726c705f6c6973745f73697a65000003656e760f706c61746f6e5f726c705f6c697374000503656e760e726c705f62797465735f73697a65000703656e7610706c61746f6e5f726c705f6279746573000503656e760d726c705f753132385f73697a65000d03656e760f706c61746f6e5f726c705f75313238000903656e7617706c61746f6e5f6765745f696e7075745f6c656e677468000a03656e7610706c61746f6e5f6765745f696e707574000103656e760d706c61746f6e5f72657475726e0002032120030404010005060603000c020701000401020007000102020103020b030000060405017001030305030100020608017f0141e088040b073904066d656d6f72790200115f5f7761736d5f63616c6c5f63746f7273000d0f5f5f66756e63735f6f6e5f65786974002606696e766f6b6500150908010041010b020e0f0a9a2e20040010290b040010020b040010030be90502097f047e230041306b22052400200541206a2102200541206a10012101034020010440200b420886200a42388884210b2001417f6a21012002310000200a42088684210a200241016a21020c010b0b20004200370200200041086a41003602004100210103402001410c470440200020016a4100360200200141046a21010c010b0b0240027f20002d00002201410171450440200141017622024128200241284b1b41106a41f001712101410a0c010b200028020422024128200241284b1b41106a41707122012000280200417e712203460d012003417f6a0b210641002001417f6a20064d2001101122031b0d0020032000280208200041016a20002d0000220641017122041b2000280204200641017620041b41016a10122000200336020820002002360204200020014101723602000b200041016a2107200541186a21080340200541106a200a200b101320052005290310220c2008290300220d10142005290300200a7ca74180086a2d00002106024002400240027f20002d000022034101712204450440410a210220034101760c010b20002802002203417e71417f6a210220002802040b220120024604402000280208200720034101711b2109416f2104200241e6ffffff074d0440410b20024101742203200241016a220420042003491b220341106a4170712003410b491b21040b20041011220320092002101220002004410172360200200020033602080c010b2004450d01200028020821030b2000200141016a3602040c010b2000200141017441026a3a0000200721030b200120036a220141003a0001200120063a0000200a4209562101200b4200522102200b502103200c210a200d210b2001200220031b0d000b0240200028020420002d00002201410176200141017122011b2202450d0020022000280208200720011b22006a417f6a21010340200020014f0d0120002d00002102200020012d00003a0000200120023a00002001417f6a2101200041016a21000c000b000b200541306a24000b0b002000410120001b10160b10002002044020002001200210281a0b0b3701017f230041106b22032400200320012002102c200329030021012000200341086a29030037030820002001370300200341106a24000b7701017e20002001427f7e200242767e7c2001422088220242ffffffff0f7e7c200242f6ffffff0f7e200142ffffffff0f83220142f6ffffff0f7e22034220887c22024220887c200142ffffffff0f7e200242ffffffff0f837c22024220887c3703082000200342ffffffff0f832002422086843703000b930802087f017e23004180016b220324001029100a220010162201100b0240200341086a20012000411c10172202280208450440200241146a2802002100200228021021010c010b200341386a2002101820022003280238200328023c101936020c200341e0006a20021018410021002002027f410020032802602204450d001a410020032802642206200228020c2205490d001a200620052005417f461b210020040b2201360210200241146a2000360200200241003602080b200341e0006a20012000411410172200101a024002402000280204450d002000101a0240200028020022042c0000220141004e044020010d010c020b200141807f460d00200141ff0171220541b7014d0440200028020441014d04401000200028020021040b20042d00010d010c020b200541bf014b0d012000280204200141ff017141ca7e6a22014d04401000200028020021040b200120046a2d0000450d010b2000280204450d0020042d000041c001490d010b10000b2000101b2206200028020422044b04401000200028020421040b20002802002107024002400240200404404100210520072c00002200417f4a0d01027f200041ff0171220541bf014d04404100200041ff017141b801490d011a200541c97e6a0c010b4100200041ff017141f801490d001a200541897e6a0b41016a21050c010b4101210520070d00410021000c010b41002100200520066a20044b0d0020042006490d004100210120042005490d01200520076a2101200420056b20062006417f461b22004109490d0110000c010b410021010b0340200004402000417f6a210020013100002008420886842108200141016a21010c010b0b024002402008500d00418b08101c20085104402002101d0c020b419008101c200851044020024101101e0c020b419d08101c200851044020024102101e0c020b41af08101c2008520d002002101d200341286a1010200341386a101f2100200341f8006a4100360200200341f0006a4200370300200341e8006a42003703002003420037036041012101024002400240200341d0006a200341286a1020220428020420032d00502202410176200241017122051b220241014d0440200241016b0d032004280208200441016a20051b2c0000417f4c0d010c030b200241374b0d010b200241016a21010c010b2002102120026a41016a21010b20032001360260200341e0006a41047210222000200110232000200341e0006a200341286a10202201280208200141016a20032d0060220241017122041b22052001280204200241017620041b22011006200028020422026a102420052001200220002802006a100720001025200028020c200041106a28020047044010000b20002802002000280204100c200028020c2201450d01200020013602100c010b10000b102620034180016a24000b9b0101047f230041106b220124002001200036020c2000047f41d808200041086a2202411076220041d8082802006a220336020041d40841d408280200220420026a41076a417871220236020002400240200341107420024d044041d808200341016a360200200041016a21000c010b2000450d010b200040000d0010000b20042001410c6a4104102841086a0541000b2100200141106a240020000b730020004200370210200042ffffffff0f370208200020023602042000200136020002402003410871450d002000102a20024f0d002003410471044010000c010b200042003702000b02402003411071450d002000102a20024d0d0020034104710440100020000f0b200042003702000b20000b7201047f2001101b220220012802044b044010000b2001102b21032000027f0240200128020022054504400c010b200220036a200128020422014b0d0020012003490d00410020012002490d011a200320056a2104200120036b20022002417f461b0c010b41000b360204200020043602000b2701017f230041206b22022400200241086a2000200141141017102a2100200241206a240020000b4101017f200028020445044010000b0240200028020022012d0000418101470d00200028020441014d047f100020002802000520010b2c00014100480d0010000b0bff0201037f200028020445044041000f0b2000101a41012102024020002802002c00002201417f4a0d00200141ff0171220341b7014d0440200341807f6a0f0b02400240200141ff0171220141bf014d0440024020002802042201200341c97e6a22024d047f100020002802040520010b4102490d0020002802002d00010d0010000b200241054f044010000b20002802002d000145044010000b4100210241b7012101034020012003460440200241384f0d030c0405200028020020016a41ca7e6a2d00002002410874722102200141016a21010c010b000b000b200141f7014d0440200341c07e6a0f0b024020002802042201200341897e6a22024d047f100020002802040520010b4102490d0020002802002d00010d0010000b200241054f044010000b20002802002d000145044010000b4100210241f701210103402001200346044020024138490d0305200028020020016a418a7e6a2d00002002410874722102200141016a21010c010b0b0b200241ff7d490d010b10000b20020b3901027e42a5c688a1c89ca7f94b210103402000300000220250450440200041016a2100200142b383808080207e20028521010c010b0b20010b8b0101047f230041106b22012400024002402000280204450d0020002802002d000041c001490d00200141086a2000101841012103200128020c2100034020000440200141002001280208220220022000101922046a20024520002004497222021b3602084100200020046b20021b21002003417f6a21030c010b0b2003450d010b10000b200141106a24000b920202027f037e230041406a220324002000101d41012100200320011104002104200341086a101f210241002101200341386a4100360200200341306a4200370300200341286a42003703002003420037032020044280015a044020042105034020052006845045044020064238862005420888842105200141016a2101200642088821060c010b0b200141384f047f2001102120016a0520010b41016a21000b20032000360220200341206a41047210222002200010232002420020041008200228020422016a102442002004200120022802006a100920021025200228020c200241106a28020047044010000b20022802002002280204100c200228020c22010440200220013602100b200341406b24000b29002000410036020820004200370200200041001027200041146a41003602002000420037020c20000ba10101037f20004200370200200041086a2202410036020020012d0000410171450440200020012902003702002002200141086a28020036020020000f0b20012802082103024020012802042201410a4d0440200020014101743a0000200041016a21020c010b200141106a4170712204101121022000200136020420002004410172360200200020023602080b2002200320011012200120026a41003a000020000b1e01017f03402000044020004108762100200141016a21010c010b0b20010b860201067f200028020422032000280210220141087641fcffff07716a2102027f200320002802082204460440200041146a210641000c010b2003200028021420016a220541087641fcffff07716a280200200541ff07714102746a2105200041146a21062002280200200141ff07714102746a0b21010340024020012005460440200641003602000340200420036b41027522014103490d022000200341046a22033602040c000b000b200141046a220120022802006b418020470d0120022802042101200241046a21020c010b0b2001417f6a220241014d04402000418004418008200241016b1b3602100b03402003200447044020002004417c6a22043602080c010b0b0b1300200028020820014904402000200110270b0b3601017f2000280208200149044020011016200028020020002802041028210220002001360208200020023602000b200020013602040b7a01037f0340024020002802102201200028020c460d00200141786a2802004504401000200028021021010b200141786a22022002280200417f6a220336020020030d002000200236021020002001417c6a2802002201200028020420016b220210046a1024200120002802006a22012002200110050c010b0b0b880101037f41c408410136020041c8082802002100034020000440034041cc0841cc082802002201417f6a2202360200200141014845044041c4084100360200200020024102746a22004184016a280200200041046a28020011010041c408410136020041c80828020021000c010b0b41cc08412036020041c808200028020022003602000c010b0b0b2f01017f2000280208200149044020011016200028020020002802041028210220002001360208200020023602000b0bfc0801067f03400240200020046a2105200120046a210320022004460d002003410371450d00200520032d00003a0000200441016a21040c010b0b200220046b210602402005410371220745044003402006411049450440200020046a2203200120046a2205290200370200200341086a200541086a290200370200200441106a2104200641706a21060c010b0b027f2006410871450440200120046a2103200020046a0c010b200020046a2205200120046a2204290200370200200441086a2103200541086a0b21042006410471044020042003280200360200200341046a2103200441046a21040b20064102710440200420032f00003b0000200341026a2103200441026a21040b2006410171450d01200420032d00003a000020000f0b024020064120490d002007417f6a220741024b0d00024002400240024002400240200741016b0e020102000b2005200120046a220328020022073a0000200541016a200341016a2f00003b0000200041036a2108200220046b417d6a2106034020064111490d03200420086a2203200120046a220541046a2802002202410874200741187672360200200341046a200541086a2802002207410874200241187672360200200341086a2005410c6a28020022024108742007411876723602002003410c6a200541106a2802002207410874200241187672360200200441106a2104200641706a21060c000b000b2005200120046a220328020022073a0000200541016a200341016a2d00003a0000200041026a2108200220046b417e6a2106034020064112490d03200420086a2203200120046a220541046a2802002202411074200741107672360200200341046a200541086a2802002207411074200241107672360200200341086a2005410c6a28020022024110742007411076723602002003410c6a200541106a2802002207411074200241107672360200200441106a2104200641706a21060c000b000b2005200120046a28020022073a0000200041016a21082004417f7320026a2106034020064113490d03200420086a2203200120046a220541046a2802002202411874200741087672360200200341046a200541086a2802002207411874200241087672360200200341086a2005410c6a28020022024118742007410876723602002003410c6a200541106a2802002207411874200241087672360200200441106a2104200641706a21060c000b000b200120046a41036a2103200020046a41036a21050c020b200120046a41026a2103200020046a41026a21050c010b200120046a41016a2103200020046a41016a21050b20064110710440200520032d00003a00002005200328000136000120052003290005370005200520032f000d3b000d200520032d000f3a000f200541106a2105200341106a21030b2006410871044020052003290000370000200541086a2105200341086a21030b2006410471044020052003280000360000200541046a2105200341046a21030b20064102710440200520032f00003b0000200541026a2105200341026a21030b2006410171450d00200520032d00003a00000b20000b3501017f230041106b220041e0880436020c41d008200028020c41076a417871220036020041d408200036020041d8083f003602000b2e01017f200028020445044041000f0b4101210120002802002c0000417f4c047f2000102b2000101b6a0520010b0b5b00027f027f41002000280204450d001a410020002802002c0000417f4a0d011a20002802002d0000220041bf014d04404100200041b801490d011a200041c97e6a0c010b4100200041f801490d001a200041897e6a0b41016a0b0bbe0202027f047e2000027e2002500440420021022001420a800c010b0240027e200141fd00200279a76b220341c000460d001a2003413f4d0440200241c00020036bad22058620012003ad2207888421062002200788210820012005862107420021050c020b200241800120036bad2205862001200341406aad22068884210720022006882106200120058621050c010b21072002210641c00021030b03402003044020084201862006423f888422022002427f8542007c20064201862007423f88842206427f852202420a7c200254ad7c423f8722024200837d20062002420a83220154ad7d2108200620017d210620074201862005423f888421072003417f6a21032004ad20054201868421052002a741017121040c010b0b20074201862005423f888421022004ad2005420186427e83840b370300200020023703080b0b4701004180080b403031323334353637383900696e697400676574506c61744f4e47617300676574506c61744f4e4761734c696d697400676574506c61744f4e4761735072696365";

    public static String BINARY = BINARY_0;

    public static final String FUNC_GETPLATONGAS = "getPlatONGas";

    public static final String FUNC_GETPLATONGASLIMIT = "getPlatONGasLimit";

    public static final String FUNC_GETPLATONGASPRICE = "getPlatONGasPrice";

    protected SpecialFunctionsB(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider, Long chainId) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider, chainId);
    }

    protected SpecialFunctionsB(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, Long chainId) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider, chainId);
    }

    public static RemoteCall<SpecialFunctionsB> deploy(Web3j web3j, Credentials credentials, GasProvider contractGasProvider, Long chainId) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(SpecialFunctionsB.class, web3j, credentials, contractGasProvider, encodedConstructor, chainId);
    }

    public static RemoteCall<SpecialFunctionsB> deploy(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, Long chainId) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(SpecialFunctionsB.class, web3j, transactionManager, contractGasProvider, encodedConstructor, chainId);
    }

    public static RemoteCall<SpecialFunctionsB> deploy(Web3j web3j, Credentials credentials, GasProvider contractGasProvider, BigInteger initialVonValue, Long chainId) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(SpecialFunctionsB.class, web3j, credentials, contractGasProvider, encodedConstructor, initialVonValue, chainId);
    }

    public static RemoteCall<SpecialFunctionsB> deploy(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, BigInteger initialVonValue, Long chainId) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(SpecialFunctionsB.class, web3j, transactionManager, contractGasProvider, encodedConstructor, initialVonValue, chainId);
    }

    public RemoteCall<Uint64> getPlatONGas() {
        final WasmFunction function = new WasmFunction(FUNC_GETPLATONGAS, Arrays.asList(), Uint64.class);
        return executeRemoteCall(function, Uint64.class);
    }

    public RemoteCall<Uint64> getPlatONGasLimit() {
        final WasmFunction function = new WasmFunction(FUNC_GETPLATONGASLIMIT, Arrays.asList(), Uint64.class);
        return executeRemoteCall(function, Uint64.class);
    }

    public RemoteCall<String> getPlatONGasPrice() {
        final WasmFunction function = new WasmFunction(FUNC_GETPLATONGASPRICE, Arrays.asList(), String.class);
        return executeRemoteCall(function, String.class);
    }

    public static SpecialFunctionsB load(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider, Long chainId) {
        return new SpecialFunctionsB(contractAddress, web3j, credentials, contractGasProvider, chainId);
    }

    public static SpecialFunctionsB load(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, Long chainId) {
        return new SpecialFunctionsB(contractAddress, web3j, transactionManager, contractGasProvider, chainId);
    }
}
