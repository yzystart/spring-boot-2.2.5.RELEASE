package com.yezhiyuan;


import com.yezhiyuan.imports.MyImportBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import(MyImportBean.class)
@SpringBootApplication
public class DebugStart {
	public static void main(String[] args) {
		SpringApplication.run(DebugStart.class,args);
	}
}
