package cn.sxt.converter;

import java.beans.FeatureDescriptor;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Map;

import com.opensymphony.xwork2.conversion.impl.DefaultTypeConverter;

public class DateConverter  extends DefaultTypeConverter {
	private final static DateFormat[] dfs=new DateFormat[]{
		new SimpleDateFormat("yyyy-MM-dd"),
		new SimpleDateFormat("yyyy/MM/dd"),
		new SimpleDateFormat("yyyy.MM.dd"),
		new SimpleDateFormat("yyyy年MM日dd")
		
	};
	
		@Override
		public Object convertValue(Map<String, Object> context, Object value,
				Class toType) {
			//把从前台传入的字符串进行格式化为自定义类型的 日期格式
			if(toType==Date.class){
				String str= ((String[]) value)[0];
				for(DateFormat df:dfs){
					try {
						System.out.println( "str =="+str);
					 	return df.parse(str);
					 
					} catch (Exception e) {
						continue;
					}
				}
				return null;
			}else{
				Date date =(Date)value;
			return new SimpleDateFormat("yyyy-MM-dd").format(date);
			}
		}
}
	
		
	


