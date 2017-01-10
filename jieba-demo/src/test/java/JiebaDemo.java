import com.huaban.analysis.jieba.JiebaSegmenter;
import org.junit.Test;

/**
 * Created by jerry on 2017/1/10.
 */
public class JiebaDemo {

    private final JiebaSegmenter segmenter;

    public JiebaDemo() {
        segmenter = new JiebaSegmenter();
    }

    @Test
    public void demoIndexSegMode() {
        System.out.println("=== Index Mode");
        String[] sentences =
                new String[] {
                        "这是一个伸手不见五指的黑夜。我叫孙悟空，我爱北京，我爱Python和C++。",
                        "我不喜欢日本和服。",
                        "雷猴回归人间。",
                        "工信处女干事每月经过下属科室都要亲口交代24口交换机等技术性器件的安装工作",
                        "结果婚的和尚未结过婚的"};

        for (String sentence : sentences) {
            System.out.println(segmenter.process(sentence, JiebaSegmenter.SegMode.INDEX).toString());
        }
    }

    @Test
    public void demoSearchSegMode() {
        System.out.println("=== Search Mode");
        String[] sentences =
                new String[] {
                        "这是一个伸手不见五指的黑夜。我叫孙悟空，我爱北京，我爱Python和C++。",
                        "我不喜欢日本和服。",
                        "雷猴回归人间。",
                        "工信处女干事每月经过下属科室都要亲口交代24口交换机等技术性器件的安装工作",
                        "结果婚的和尚未结过婚的"};

        for (String sentence : sentences) {
            System.out.println(segmenter.process(sentence, JiebaSegmenter.SegMode.SEARCH).toString());
        }
    }

    @Test
    public void tmpTest() {
        System.out.println("=== Sentence Process");
        final String sentence = "之前說過goal可是設定屬於某個phase，而phase則可組成lifecycle(生命週期)，在Maven有三個LifeCycle?，分別是 clean 、 default 與 site ， clean周期負責Project的清理，default周期負責Project的建置而site周期則是負責產生Project的文檔。例如執行 \"mvn package\" 時，因為它是屬於 defulat 這個life cycle，所以從 phase validate 到 package 的所有相關的Goals都會被執行";
        System.out.println(segmenter.sentenceProcess(sentence));
    }
}
