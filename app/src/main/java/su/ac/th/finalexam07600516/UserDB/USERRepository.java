package su.ac.th.finalexam07600516.UserDB;

import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

public class USERRepository {
    private Context mContext;

    public USERRepository(Context mContext) {
        this.mContext = mContext;
    }

    public void getUser(Callback callback) {
        GetTask getTask = new GetTask(mContext, callback);
        getTask.execute();
    }

    public void insertUser(USER user, InsertCallback callback) {
        InsertTask insertTask = new InsertTask(mContext, callback);
        insertTask.execute(user);
    }

    private static class GetTask extends AsyncTask<Void, Void, List<USER>> {

        private Context mContext;
        private Callback mCallback;

        public GetTask(Context context, Callback callback) {
            this.mContext = context;
            this.mCallback = callback;
        }

        @Override
        protected List<USER> doInBackground(Void... voids) {
            AppDatabase db = AppDatabase.getInstance(mContext);
            List<USER> usernameList = db.userDao().getAllUser();
            return usernameList;
        }

        @Override
        protected void onPostExecute(List<USER> userList) {
            super.onPostExecute(userList);

            mCallback.onGetLedger(userList);
        }
    }

    public interface Callback {
        void onGetLedger(List<USER> userList);
    }

    private static class InsertTask extends AsyncTask<USER, Void, Void> {

        private Context mContext;
        private InsertCallback mCallback;

        public InsertTask(Context context, InsertCallback callback) {
            this.mContext = context;
            this.mCallback = callback;
        }

        @Override
        protected Void doInBackground(USER... UserLists) {
            AppDatabase db = AppDatabase.getInstance(mContext);
            db.userDao().insertUser(UserLists[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            mCallback.onInsertSuccess();
        }
    }

    public interface InsertCallback {
        void onInsertSuccess();
    }
}
