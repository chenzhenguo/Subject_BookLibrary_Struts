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
		new SimpleDateFormat("yyyy��MM��dd")
		
	};
	
		@Override
		public Object convertValue(Map<String, Object> context, Object value,
				Class toType) {
			//�Ѵ�ǰ̨������ַ������и�ʽ��Ϊ�Զ������͵� ���ڸ�ʽ
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
	
		
	


