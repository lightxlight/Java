//һ��������������·��Ľӿ�
interface Cloth {
    void ProduceCloth();//�����������������·�
}
/**
 * �Ϳ˹�˾�ı������࣬ʵ����������·�
 */
class Nike implements Cloth {

    @Override
    public void ProduceCloth() {
        System.out.println("Nike->Many Cloth be made!");
    }
}
/**
 * ������˾�ı������࣬ʵ����������·�
 */
class LiNing implements Cloth {

    @Override
    public void ProduceCloth() {
       System.out.println("LiNing->Many Cloth be made!");
    }
}
/**
 * һ����̬�����࣬������ʵ��Cloth�ӿڵ�ʵ����
 */
class ClothProxy implements Cloth {

    //��ȻҪ����������ķ�������Ҫ�ѱ�������Ķ��󴫽�������Ϊ�����ಢ���ṩCloth������ʵ�֣�
    Cloth cloth;    // �����Ĺ���ʵ����

    //���뱻���������,ע��ʹ�õ��ǽӿ����ͣ��Ᵽ֤�˸ô����������Դ���ͬһ�ӿڵĲ�ͬʵ����
    public ClothProxy(Cloth cloth) {
        this.cloth = cloth;
    }

    //���������ִ�нӿ���ķ�����ʵ���ǵ��ñ��������ʵ��
 	
    @Override
    public void ProduceCloth() {
		//ע�⣺���ڴ�����ʵ�ʿ����ű�������ʵ�ֵķ��������Դ���������ڵ��ñ�������ʵ�ֵķ�����ǰ����һЩ��չ�������������Զ�Ӧ��Ʒ�����ۻ��
        System.out.println("��������Ķ��󷽷���ִ����");//������Ķ���Ա����������������չ

        cloth.ProduceCloth();//ִ��ʵ�ʵ������·��Ĺ���

        System.out.println("��������Ķ��󷽷�ִ�н���");
		}
		//������Ķ���Ϊ�����������������չ
    
@Test
public void testProxyStatic() {
        //ʵ����һ�������������
        Nike nike = new Nike();
        //ʵ������һ�������������
        LiNing liNing = new LiNing();


        //ʵ����һ�����������,���ݴ���ı����������Ĳ�ͬ��ִ�в�ͬ��ʵ��
        ClothProxy proxy = new ClothProxy(nike);
        ClothProxy proxy1 = new ClothProxy(liNing);

        //ִ�д�����ķ���
        proxy.ProduceCloth();
        System.out.println();
        proxy1.ProduceCloth();

}