//
//  refs http://hetare-engineer.blogspot.com/2011/09/java-javagroovy.html
//       http://www.ibm.com/developerworks/jp/java/library/j-pg05245/
//       http://d.hatena.ne.jp/arcanum_jp/20110719/1311088725
//
filename= args.size() ==0 ? "test.groovy":args[0]

import groovy.util.GroovyScriptEngine;
import org.codehaus.groovy.control.CompilerConfiguration;
import groovy.lang.*;

def dto = new Expando();
dto.name="hetare";
dto.date="2011/09";
dto.article="java-javagroovy.html";
dto.japan="あいうえお～";

// スクリプトにパラメータをBindする
//Binding binding = new Binding()
//binding.setProperty("formula", dto)
def binding = ['formula':dto] as Binding;

// [1]スクリプトを実行する
// GroovyScriptエンジンを生成する
CompilerConfiguration config = new CompilerConfiguration(sourceEncoding:'UTF-8');//equals -Dgroovy.source.encoding=UTF-8

String[] roots = ['.'];
GroovyScriptEngine engine = new GroovyScriptEngine(roots);
engine.setConfig(config);
println engine.run(filename, binding);

println "="*20

// [2]スクリプトを実行する
// GroovyShを生成する
GroovyShell gse = new GroovyShell(binding,config);
def source = new GroovyCodeSource(new File(filename),"UTF-8");//equals -Dfile.encoding=UTF-8
println gse.evaluate(source); 
