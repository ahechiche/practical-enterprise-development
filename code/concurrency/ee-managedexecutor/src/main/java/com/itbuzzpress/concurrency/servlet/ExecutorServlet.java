package com.itbuzzpress.concurrency.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.annotation.Resource;
 
import javax.enterprise.concurrent.ManagedExecutorService;

import com.itbuzzpress.concurrency.job.SimpleTask;
 
/**
 * Servlet implementation class Test
 */
@WebServlet("/ExecutorServlet")
public class ExecutorServlet extends HttpServlet {
 
    @Resource(name = "DefaultManagedExecutorService")
    ManagedExecutorService executor;
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		
		executor.execute(new SimpleTask());	 
		
		writer.write("Task SimpleTask executed! check logs");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
