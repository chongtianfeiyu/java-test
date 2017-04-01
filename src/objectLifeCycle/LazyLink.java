package objectLifeCycle;

/*
 * 类加载
 * 类链接（验证（字节代码结构是否正确）、准备（保证类加载时类型安全）、解析（加载java类中包含的形式引用））
 * 类初始化（静态域、静态代码块）
 * 对象初始化 （域、代码块）
 * 对象创建
 */
// 延迟解析
public class LazyLink {
	public static void main(String[] args) {
		ToBeLinked beLinked = null;// 若吧ToBeLinked的class删除，执行改语句若没有报错，代表用了延迟解析
		System.out.println("使用了延迟解析");
	}
}
