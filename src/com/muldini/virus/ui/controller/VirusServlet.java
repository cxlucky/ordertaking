/*
COPYRIGHT (C) 2018 BY MULDINI. ALL RIGHTS RESERVED.
*/

package com.muldini.virus.ui.controller;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

import com.muldini.virus.biz.service.AreaTreeService;
import com.muldini.virus.biz.service.ChinaTotalService;
import com.muldini.virus.common.AreaTree;
import com.muldini.virus.common.ChinaTotal;
import com.muldini.virus.common.StringConstant;


@WebServlet("/virus")
public class VirusServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
    private VirusInsect  virusInsect;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
       request.setCharacterEncoding("utf-8");
       boolean t = false;
		String time = null;
		ChinaTotal chinaTotal = new ChinaTotal();
      AreaTree areaTree = new AreaTree();
      ChinaTotalService chinaTotalService = ChinaTotalService.INSTANCE;
      AreaTreeService areaTreeService = AreaTreeService.INSTANCE;
      
       HttpSession session = request.getSession();
    if(session.getAttribute(StringConstant.REQ_UPLOAD_MSG)==null||session.getAttribute(StringConstant.REQ_UPLOAD_AREA)==null) {
    	
        String str = virusInsect.getWuMaoW().replace("</body>", "").replace("</html>", "").replace(" ", "").replace("{\"ret\":0,\"data\":\"", "").replace("\"}", "");
        JSONObject jsonObj= null;
        JSONObject chinajson= null;
    	Pattern p = Pattern.compile("\\s*|\t|\r|\n");
		Matcher m = p.matcher(str);
		str = m.replaceAll("").replace("<html><head></head><body>", "");

        try {
			 jsonObj = new JSONObject(str);
			 
			 chinajson =  new JSONObject(jsonObj.get("chinaTotal").toString());
			 t = chinaTotalService.retrievechinaByTime(jsonObj.getString("lastUpdateTime").toString());

			 com.alibaba.fastjson.JSONArray jsonArray=com.alibaba.fastjson.JSONArray.parseArray(jsonObj.get("areaTree").toString());
			 boolean is = true;
			 time = jsonObj.getString("lastUpdateTime").toString();
			 if(!t) {
				 chinaTotal.setConfirm(chinajson.get("confirm").toString());
				 chinaTotal.setDead(chinajson.get("dead").toString());
				 chinaTotal.setHeal(chinajson.get("heal").toString());
				 chinaTotal.setImportedCase(chinajson.get("importedCase").toString());
				 chinaTotal.setLocalConfirm(chinajson.get("localConfirm").toString());
				 chinaTotal.setLocalConfirmH5(chinajson.get("localConfirmH5").toString());
				 chinaTotal.setNoInfect(chinajson.get("noInfect").toString());
				 chinaTotal.setNowConfirm(chinajson.get("nowConfirm").toString());
				 chinaTotal.setNowSevere(chinajson.get("nowSevere").toString());
				 chinaTotal.setShowLocalConfirm(chinajson.get("showLocalConfirm").toString());
				 chinaTotal.setShowlocalinfeciton(chinajson.get("showlocalinfeciton").toString());
				 chinaTotal.setSuspect(chinajson.get("suspect").toString());
				 chinaTotal.setNoInfectH5(chinajson.get("noInfectH5").toString());
				 chinaTotal.setLastupdatetime(jsonObj.getString("lastUpdateTime").toString());
				 
				 chinaTotalService.createchaintotal(chinaTotal);
				 
				 int a = 0;
				 while(is) {
					 com.alibaba.fastjson.JSONObject object= (com.alibaba.fastjson.JSONObject) jsonArray.get(0);
				     List<Object> list = object.getJSONArray("children");
					 if(a<list.size()) {
						 com.alibaba.fastjson.JSONArray jsonArra=com.alibaba.fastjson.JSONArray.parseArray("["+list.get(a++).toString()+"]");

						 com.alibaba.fastjson.JSONObject objec= (com.alibaba.fastjson.JSONObject) jsonArra.get(0);
					     
						 String[] stra =  objec.get("today").toString().replace("}", "").split(",");
						 String[] strb =  objec.get("total").toString().replace("}", "").split(",");
						 areaTree.setName(objec.get("name").toString());
						 areaTree.setCount_confirm(stra[0].split(":")[1]);
						 areaTree.setCount_confirmcuts(stra[1].split(":")[1]);
						 areaTree.setCount_wzz_add(stra[4].split(":")[1]);
						 areaTree.setConfirm(strb[0].split(":")[1]);
						 areaTree.setDead(strb[1].split(":")[1]);
						 areaTree.setHeal(strb[3].split(":")[1]);
						 areaTree.setWzz(strb[9].split(":")[1]);
						 areaTree.setSuspect(strb[8].split(":")[1]);
						 areaTree.setNowconfirm(strb[5].split(":")[1]);
						 areaTree.setShowheal(strb[6].split(":")[1]);
						 areaTree.setShowrate(strb[7].split(":")[1]);
						 areaTree.setLastupdatetime(jsonObj.getString("lastUpdateTime").toString());
						 
						 areaTreeService.createAreaTree(areaTree);
						 
					 }
					 else is = false;
				 }
			 }
		} catch (JSONException e) {
			e.printStackTrace();
		}
        session.setAttribute(StringConstant.REQ_UPLOAD_MSG, chinaTotalService.retrieveChina());
        session.setAttribute(StringConstant.REQ_UPLOAD_AREA, areaTreeService.retrieveTop5ListareaByTime(time));
    }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
