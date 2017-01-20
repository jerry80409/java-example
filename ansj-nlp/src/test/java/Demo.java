import org.ansj.domain.Result;
import org.ansj.domain.Term;
import org.ansj.library.DicLibrary;
import org.ansj.recognition.impl.NatureRecognition;
import org.ansj.splitWord.analysis.BaseAnalysis;
import org.ansj.splitWord.analysis.DicAnalysis;
import org.ansj.splitWord.analysis.IndexAnalysis;
import org.ansj.splitWord.analysis.NlpAnalysis;
import org.ansj.splitWord.analysis.ToAnalysis;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by jerry on 2017/1/10.
 */
public class Demo {

    @Test
    public void demo1() {
        String str = "未來如果要抽取出規則或是意義,不太能指望現有軟體,其實語言的演化很難精確掌握,例如究竟是斷詞還是斷辭呢" ;

        System.out.println(BaseAnalysis.parse(str));
        System.out.println(ToAnalysis.parse(str));
        System.out.println(DicAnalysis.parse(str));
        System.out.println(IndexAnalysis.parse(str));
        System.out.println(NlpAnalysis.parse(str));
    }

    @Test
    public void demo2() {
        Result parse = BaseAnalysis.parse("正男好帥");
        System.out.println("Terms: " + parse.getTerms());
        System.out.println(parse.toStringWithOutNature());
    }

    @Test
    public void insertKeyWord() {
        DicLibrary.insert(DicLibrary.DEFAULT, "增加新词");
        Result parse = DicAnalysis.parse("这是用户自定义词典增加新词的例子");
        System.out.println(parse);
        boolean flag = false;
        for (Term term : parse) {
            flag = flag || "增加新词".equals(term.getName());
        }
        Assert.assertTrue(flag);
    }
}
