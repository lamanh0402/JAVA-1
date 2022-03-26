package duan;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {
	public static ArrayList<Thu> findAllThu() {
		ArrayList<Thu> listthu=new ArrayList<>();
		Connection connection = null;
        Statement statement = null;
    	
    	try {
    		connection =DriverManager.getConnection("jdbc:mysql://localhost:8889/QLThuChi","root","root");//tạo kết nối//
            String sql="select*from THU";
            statement = connection.createStatement();//tạo câu lệnh truy vấn SQl//
            ResultSet rs = statement.executeQuery(sql);
             while(rs.next()) {
            	Thu thu=new Thu();
            	thu.setsophieu(rs.getInt(1));
            	thu.sethocvien(rs.getString(2));
            	thu.setnhanvien(rs.getString(3));
            	thu.setdichvu(rs.getString(4));
            	thu.setngaythu(rs.getString(5));
            	thu.setsotien(rs.getDouble(6));
            	thu.setthutruoc(rs.getDouble(7));
            	thu.settrangthaithu(rs.getString(8));
                listthu.add(thu);
            }
    	}catch(SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
    	}finally {
    		if(statement!=null) {
    			try {statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
		return listthu;
	}
	public static void  insert(Thu thu) {
		Connection connection = null;
        PreparedStatement st = null;
    	try {   
    		connection =DriverManager.getConnection("jdbc:mysql://localhost:8889/QLThuChi","root","root");
            String sql="insert into THU (sophieu, hocvien, nhanvien, dichvu, ngaythu, sotien, thutruoc, trangthaithu)"+"values(?,?,?,?,?,?,?,?)";
            st = connection.prepareCall(sql);
    		st.setInt(1, thu.getsophieu());
            st.setString(2, thu.gethocvien());
            st.setString(3, thu.getnhanvien());
            st.setString(4, thu.getdichvu());
            st.setString(5, thu.getngaythu());
            st.setDouble(6, thu.getsotien());
            st.setDouble(7, thu.getthutruoc());
            st.setString(8, thu.gettrangthaithu());
            st.setString(9,thu.getdiachi());
            st.execute();
    		
    	} catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
		public static void deleteThu(int i) {
		Connection connection = null;
	     PreparedStatement st = null;
	        
   	try {
   		connection =DriverManager.getConnection("jdbc:mysql://localhost:8889/QLThuChi","root","root");
    		String sql="delete from THU where sophieu=?";
    		st = connection.prepareCall(sql);
            st.setInt(1, i);
            st.execute();
	} catch (SQLException ex) {
        Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        if(st != null) {
            try {
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
	}
   
	public static ArrayList<Thu> findhocvien(String hocvien){
		ArrayList<Thu> listthu=new ArrayList<>();
		Connection connection = null;
	    PreparedStatement st = null;
	        
  	try {
  		connection =DriverManager.getConnection("jdbc:mysql://localhost:8889/QLThuChi","root","root");
  		String sql="select*from THU where hocvien like?";
  		st = connection.prepareCall(sql);
        st.setString(1, "%"+hocvien+"%");
        
        ResultSet rs = st.executeQuery();
        while (rs.next()) {  
        	Thu thu=new Thu();
        	thu.setsophieu(rs.getInt(1));
        	thu.sethocvien(rs.getString(2));
        	thu.setnhanvien(rs.getString(3));
        	thu.setdichvu(rs.getString(4));
        	thu.setngaythu(rs.getString(5));
        	thu.setsotien(rs.getDouble(6));
        	thu.setthutruoc(rs.getDouble(7));
        	thu.settrangthaithu(rs.getString(8));
            listthu.add(thu);
        
        }
  	   }catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return listthu;
	}
	//////////////////////////////////////
	public static ArrayList<Chi> findAllChi(){
		ArrayList<Chi> listchi=new ArrayList<>();
			Connection connection = null;
	        Statement statement = null;
	    	try {
	    		connection =DriverManager.getConnection("jdbc:mysql://localhost:8889/QLThuChi","root","root");
	            String sql="select*from CHI";
	            statement = connection.createStatement();
	            ResultSet rs = statement.executeQuery(sql);
	             while(rs.next()) {
	            	Chi chi=new Chi();
	            	chi.setsophieuchi(rs.getInt(1));
	            	chi.setgiangvien(rs.getString(2));
	            	chi.setnhanvienchi(rs.getString(3));
	            	chi.setdichvuchi(rs.getString(4));
	            	chi.setngaychi(rs.getString(5));
	            	chi.setsotienchi(rs.getDouble(6));
	                listchi.add(chi);
	            }
	    	}catch(SQLException ex) {
	            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
	    	}finally {
	    		if(statement!=null) {
	    			try {statement.close();
	                } catch (SQLException ex) {
	                    Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
	                }
	            }

	            if (connection != null) {
	                try {
	                    connection.close();
	                } catch (SQLException ex) {
	                    Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
	                }
	            }
	        }
			return listchi;
		}
	public static void insertchi(Chi chi) {
		Connection connection = null;
        PreparedStatement st = null;
    	try {   
    		connection =DriverManager.getConnection("jdbc:mysql://localhost:8889/QLThuChi","root","root");
            String sql="insert into CHI (sophieuchi, giangvien, nhanvienchi, dichvuchi, ngaychi, sotienchi)"+"values(?,?,?,?,?,?)";
            st = connection.prepareCall(sql);
    		st.setInt(1, chi.getsophieuchi());
            st.setString(2, chi.getgiangvien());
            st.setString(3, chi.getnhanvienchi());
            st.setString(4, chi.getdichvuchi());
            st.setString(5, chi.getngaychi());
            st.setDouble(6, chi.getsotienchi());
             st.execute();
    	} catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
	}
	public static void deletechi(int i) {
		Connection connection=null;
		PreparedStatement st =null;
		try {
			connection =DriverManager.getConnection("jdbc:mysql://localhost:8889/QLThuChi","root","root");
		    String sql="delete from CHI where sophieuchi=?";
			st= connection.prepareCall(sql);
			st.setInt(1, i);
		    st.execute();
		     
		}catch(Exception ex) {
			 Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
	    } finally {
	        if(st != null) {
	            try {
	                st.close();
	            } catch (SQLException ex) {
	                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
	            }
	        }
	        
	        if (connection != null) {
	            try {
	                connection.close();
	            } catch (SQLException ex) {
	                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
	            }
	        }
	    }
		}
	public static ArrayList<Chi> findgiangvien(String giangvien){
		ArrayList<Chi> listchi=new ArrayList<>();
		Connection connection=null;
		PreparedStatement st =null;
	try {
		connection =DriverManager.getConnection("jdbc:mysql://localhost:8889/QLThuChi","root","root");
		String sql="select*from CHI where giangvien like?";
		st= connection.prepareCall(sql );
		st.setString(1,"%"+giangvien+"%");
		ResultSet rs=st.executeQuery();
		while(rs.next()) {
			Chi chi=new Chi();
			chi.setsophieuchi(rs.getInt(1));
			chi.setgiangvien(rs.getString(2));
			chi.setnhanvienchi(rs.getString(3));
            chi.setdichvuchi(rs.getString(4));
			chi.setngaychi(rs.getString(5));
			chi.setsotienchi(rs.getDouble(6));
			listchi.add(chi);
		}
	 }catch (SQLException ex) {
         Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
     } finally {
         if(st != null) {
             try {
                 st.close();
             } catch (SQLException ex) {
                 Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
         
         if (connection != null) {
             try {
                 connection.close();
             } catch (SQLException ex) {
                 Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
     }
     
     return listchi;
	}
	///////////////////////////
	public static ArrayList<Thu > finddanop (String trangthaithu ){
		ArrayList<Thu> listthu =new ArrayList<>();
		Connection connection=null;
		PreparedStatement st =null;
	try {

		connection =DriverManager.getConnection("jdbc:mysql://localhost:8889/QLThuChi","root","root");
		String sql="SELECT * FROM THU WHERE trangthaithu =' Đã nộp'";
		st= connection.prepareCall(sql );
        ResultSet rs = st.executeQuery(sql);
   while(rs.next()) {
        	Thu thu=new Thu();
        	thu.setsophieu(rs.getInt(1));
        	thu.sethocvien(rs.getString(2));
        	thu.setnhanvien(rs.getString(3));
        	thu.setdichvu(rs.getString(4));
        	thu.setngaythu(rs.getString(5));
        	thu.setsotien(rs.getDouble(6));
        	thu.setthutruoc(rs.getDouble(7));
        	thu.settrangthaithu(rs.getString(8));
            listthu.add(thu);
        }
	}catch(SQLException ex) {
        Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
	}finally {
		if(st!=null) {
			try {st.close();
            } catch (SQLException ex) {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
	return listthu;
}
	public static ArrayList<Thu > findchuanop (String trangthaithu ){
		ArrayList<Thu> listthu =new ArrayList<>();
		Connection connection=null;
		PreparedStatement st =null;
	try {

		connection =DriverManager.getConnection("jdbc:mysql://localhost:8889/QLThuChi","root","root");
		String sql="SELECT * FROM THU WHERE trangthaithu=' Chưa nộp'";
		st= connection.prepareCall(sql );
        ResultSet rs = st.executeQuery(sql);
   while(rs.next()) {
        	Thu thu=new Thu();
        	thu.setsophieu(rs.getInt(1));
        	thu.sethocvien(rs.getString(2));
        	thu.setnhanvien(rs.getString(3));
        	thu.setdichvu(rs.getString(4));
        	thu.setngaythu(rs.getString(5));
        	thu.setsotien(rs.getDouble(6));
        	thu.setthutruoc(rs.getDouble(7));
        	thu.settrangthaithu(rs.getString(8));
            listthu.add(thu);
        }
	}catch(SQLException ex) {
        Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
	}finally {
		if(st!=null) {
			try {st.close();
            } catch (SQLException ex) {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
	return listthu;
}

}
	