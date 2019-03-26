
package com.pool.task;

/**
 * 任务接口
 * 
 * @author kome.Jiangmy
 * @version 1.0
 * @date 2012-9-25 上午9:30:39
 */
@FunctionalInterface
public interface TaskOne {
	/**
	 * task processore method, task control thread execute it.
	 * 
	 * @throws Exception
	 */
	 void execute() throws Exception;
}
