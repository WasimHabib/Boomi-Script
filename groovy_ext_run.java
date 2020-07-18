//
//  refs http://hetare-engineer.blogspot.com/2011/09/java-javagroovy.html
//       http://www.ibm.com/developerworks/jp/java/library/j-pg05245/
//       http://d.hatena.ne.jp/arcanum_jp/20110719/1311088725
//

import groovy.util.GroovyScriptEngine;
import org.codehaus.groovy.control.CompilerConfiguration;
import groovy.lang.*;
import groovy.util.*;
import java.io.*;
import java.util.*;

public class groovy_ext_run{
	public static void main(String[] args) throws Exception{
		String filename= args.length ==0 ? "test.groovy":args[0];


		Expando dto = new Expando();
		dto.setProperty("name","hetare");
		dto.setProperty("date","2011/09");
		dto.setProperty("article","java-javagroovy.html");
		dto.setProperty("japan","あいうえお～");

		// スクリプトにパラメータをBindする
		Binding binding = new Binding();
		binding.setProperty("formula", dto);

		// [1]スクリプトを実行する
		// GroovyScriptエンジンを生成する
		Properties configuration = new Properties();
		configuration.setProperty("sourceEncoding", "UTF-8"); 
		CompilerConfiguration config = new CompilerConfiguration(configuration);//equals -Dgroovy.source.encoding=UTF-8

		String[] roots = {"."};
		GroovyScriptEngine engine = new GroovyScriptEngine(roots);
		engine.setConfig(config);
		System.out.println (engine.run(filename, binding));

		System.out.println("====================");

		// [2]スクリプトを実行する
		// GroovyShを生成する
		GroovyShell gse = new GroovyShell(binding,config);
		GroovyCodeSource source = new GroovyCodeSource(new File(filename),"UTF-8");//equals -Dfile.encoding=UTF-8
		System.out.println(gse.evaluate(source));
	}
}
