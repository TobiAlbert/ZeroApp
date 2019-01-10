package com.tobidaada.zeroapp

import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.koin.dsl.module.Module
import org.koin.dsl.module.module
import org.koin.standalone.StandAloneContext.startKoin
import org.koin.standalone.StandAloneContext.stopKoin
import org.koin.standalone.get
import org.koin.standalone.inject
import org.koin.test.KoinTest
import org.koin.test.checkModules

class ComponentA
class ComponentB(var a: ComponentA)

class DependencyGraphTest: KoinTest {

    // Lazy inject property
    private val componentB: ComponentB by inject()
    private lateinit var componentModule: Module

    @Before
    fun `initialize module`() {
        componentModule = module {
            single { ComponentA() }

            single { ComponentB(get()) }
        }

        startKoin(listOf(componentModule))
    }

    @Test
    fun `check modules`() {
        checkModules(listOf(componentModule))
    }

    @Test
    fun `should inject my components`() {

        // directly request an instance
        val componentA = get<ComponentA>()

        assertNotNull(componentB.a)
        assertEquals(componentA, componentB.a)
    }

    @After
    fun `close components`() {
        stopKoin()
    }

}