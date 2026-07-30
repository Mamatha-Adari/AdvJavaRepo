package studentpkg;

public class StatementStudentDriver {

	public static void main(String[] args) {
//		StatementStudent stObj=new StatementStudent();
//		stObj.createConnection();
//		stObj.selectStudent();
//		stObj.insertStdData();
//		stObj.updateStdData();
//		PrepStmtClass prSt=new PrepStmtClass();
//		prSt.createConnection();
//		prSt.createStudentDet("1235","vedha" ,"EEE", 4);
//		prSt.updateStudentDet("nissy","1210");
//		prSt.deleteStudentDet("1201");
//		prSt.readStudentDet();  
//		CallableStudent clsObj=new CallableStudent();
//		clsObj.createConnection();
//		clsObj.createCallable("1780");
//		clsObj.createFunction("3456");
		BatchUpdatesStudent bu=new BatchUpdatesStudent();
		bu.createConnection();
		bu.batchInsertSt();
		bu.batchSelectSt();
		
	}
}