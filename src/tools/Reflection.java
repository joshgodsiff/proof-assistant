package tools;


import java.lang.reflect.Method;
import java.util.Collection;
import syntax.Formula;
import naturalDeduction.AndE1;
import naturalDeduction.AndE2;
import naturalDeduction.BackwardRule;
import naturalDeduction.BackwardRule.Goal;
import naturalDeduction.Deduction;
import naturalDeduction.ForwardRule;
import naturalDeduction.ImpliesE;
import naturalDeduction.ImpliesI;
import naturalDeduction.OrI1;
import naturalDeduction.Theorem;

public class Reflection {
	
	public static Boolean hasCheck(Class<?extends Deduction> rule) {
		try {
			return (Boolean) rule.getMethod("hasCheck", null).invoke(null, null);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static Class<?> formulaClass(Class<?extends Deduction> rule) {
		try {
			return (Class<?>) rule.getMethod("formulaClass", null).invoke(null,null);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Formula check(Class<?extends Deduction> rule, Formula f, Collection<Formula> list) {
		try {
			return (Formula) rule.getMethod("check", Collection.class, Formula.class).invoke(null,
				list, f);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void init() {
		ForwardRule.forwardRules.add(AndE1.class);
		ForwardRule.forwardRules.add(AndE2.class);
		ForwardRule.forwardRules.add(ImpliesE.class);
		
		BackwardRule.register(ImpliesI.class);
		BackwardRule.register(OrI1.class);
	}
	
	public static Goal applyBackwards(Class<?extends Deduction> rule, Formula f, Theorem t) {
		try {
			return (Goal) rule.getMethod("applyBackwards", Formula.class, Theorem.class).invoke(null,  f, t);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
