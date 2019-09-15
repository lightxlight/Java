//���嶯��Ľ���
interface Yeal {
    void sound();
}
//������ӽ�����ʵ����
class Monkey implements Yeal {

    @Override
    public void sound() {
        System.out.println("a monkey`s voice!");
    }
}
class DynamicProxy {
    //��װ��������,��Ϊ��ָ���������࣬���Գ�Ա�Ƕ�����Object�Ķ���
    private Object obj;

    //����������ݴ���ı��������obj��ͨ�����䶯̬�����������������󣬲���һЩ��չ
    public Object bind(Object obj){
        this.obj = obj;
        Object proxy = Proxy.newProxyInstance(obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(),
                (proxy1,method,args)->{
                   
                    System.out.println("����"+method.getName()+"����ִ��"); //��չ����1
                    
                    Object result = method.invoke(obj, args);//ִ�б���������ʵ�ֵķ���
                    
                    System.out.println("����"+method.getName()+"ִ�����");//��չ����2
                    
                    return result;//�������෽���ķ���ֵ
                });
        return proxy;//���������������Ĵ��������
    }
}
//��̬����
    @Test
    public void testDynamicProxy(){
        //ʵ����һ�������������
        Nike nike = new Nike();
        //ʵ������һ�������������
        Monkey monkey = new Monkey();

        //ʵ����һ���������ɴ�����Ķ���
        DynamicProxy dynamicProxy1 = new DynamicProxy();
        //����Nike�Ĵ�����
        Cloth cloth = (Cloth) dynamicProxy1.bind(nike);
        //ִ�����·�
        cloth.ProduceCloth();
        System.out.println("--------------------------");

        //����monkey�Ĵ�����
        Yeal yeal = (Yeal) dynamicProxy1.bind(monkey);
        //ִ�з�������
        yeal.sound();

    }
