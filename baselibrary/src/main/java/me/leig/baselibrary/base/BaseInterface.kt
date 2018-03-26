/**********************************************************************
 *	湖南长沙阳环科技实业有限公司
 *    @Copyright (c) 2003-2017 yhcloud, Inc. All rights reserved.
 *
 *	This copy of Ice is licensed to you under the terms described in the
 *	ICE_LICENSE file included in this distribution.
 *
 *	@license http://www.yhcloud.com.cn/license/
 **********************************************************************/
package me.leig.baselibrary.base

/**
 *
 *
 *
 * @author Leig
 * @version 20180301
 *
 */

interface BaseInterface {

    fun getClassTag(): String

    fun getLayoutId(): Int

    fun initData()

    fun initView()

    fun initEvent()

}