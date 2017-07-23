package se.se.d6;

/** 
 * @Description: 
 * @Create on: 2014-11-17 ����03:22:22
 * @Author:����
 * @Version:1.0
 */
public class RoundTool {
	public static String round(double value, int dotNum){
		String strValue = String.valueOf(value);
		int pos = strValue.indexOf(".");
		int len = strValue.length();
		int dotLen = len - 1 - pos;
		double endValue = 0.0;//�������������м����
		String endNum = "";//�������ս��
		if(dotNum < dotLen){
			String cNum = strValue.substring(pos+dotNum+1,pos+dotNum+2);
			int iNum = Integer.valueOf(cNum);
			//������Ҫ����δ�����������ֵ
			String sNum = strValue.substring(0,pos+dotNum+1);
			endValue = Double.valueOf(sNum);
			if(iNum >= 5){//�������Ĵ��ڵ���5
				String endPos = "";//���Ҫ��λ��С��ֵ
				String dotValue = "";//����С�����Ķ��0
				for (int i = 1; i < dotNum; i++) {
					dotValue = dotValue + "0";
				}
				endPos = "0."+dotValue+"1";//��Ҫ��λ��С��ֵ
				double d = Double.valueOf(endPos);
				endValue = endValue + d;//�������봦���ֵ
				strValue = String.valueOf(endValue);
				pos = strValue.indexOf(".");
				len = strValue.length();
				dotLen = len - 1 - pos;//С����λ
				if(dotLen < dotNum){//С��λ���� ����λ
					for (int i = pos + dotLen + 1; i < pos + dotNum + 1; i++) {
						endNum = String.valueOf(endValue)+"0";
					}
				}else{
					endNum = String.valueOf(endValue).substring(0,pos + dotNum + 1);
				}
			}else{
				endNum = strValue.substring(0,strValue.indexOf("."))+
		        strValue.substring(strValue.indexOf("."),strValue.indexOf(".")+dotNum+1);
			}
		}else if(dotNum == dotLen){
			endNum = strValue.valueOf(value);
		}else{
			for (int i = 1; i <= dotNum-dotLen; i++) {
				strValue = strValue + "0";
			}
			endNum = strValue;
		}
		return endNum;
	}
	public static void main(String[] args) {
		System.out.println(RoundTool.round(31.45655, 4));
		double b1 = 31.4565d + 0.001d;
		System.out.println(b1);
		double b2 = 0.001;
		double db = 31.4565 + b2;
		System.out.println(db);
		double bb = 0.001;
		System.out.println(bb);
	}
}
 