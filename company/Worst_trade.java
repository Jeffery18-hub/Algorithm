/* optiver worst trade */
package company;

import java.util.HashMap;
import java.util.Scanner;

public class Worst_trade {
    HashMap<String, Integer[]> m1 = new HashMap<>(); // instrumentid + buy_sell as key, [trade_id, price] as value
    HashMap<String, Integer> m2 = new HashMap<>(); // instumentid as key, current_price as value

    public void process_trade(int trade_id, String instrument_id, String buy_sell,int price, int volume) {
        String key = instrument_id + "_" + buy_sell;
        
        if(!m1.containsKey(key)) {
            m1.put(key, new Integer[]{trade_id, price});
        } else {
            if(buy_sell.equals("BUY") && price >= m1.get(key)[1]) {
                m1.put(key, new Integer[]{trade_id, price});
            }
            if(buy_sell.equals("SELL") && price <= m1.get(key)[1]) {
                m1.put(key, new Integer[]{trade_id, price});
            }
        }
    }

    public void process_price_update(String instrument_id, int price) {
        m2.put(instrument_id, price);
    }

    public String output_worst_trade(String instrument_id) {
        String buy_key = instrument_id + "_BUY";
        String sell_key = instrument_id + "_SELL";
        int sell_pnl = 0;
        int buy_pnl = 0;
        if(m1.get(sell_key) != null) { 
            Integer[] sell_trade = m1.get(sell_key);
            sell_pnl = sell_trade[1] - m2.get(instrument_id) < 0? sell_trade[1] - m2.get(instrument_id):0;
        }
        if(m1.get(buy_key) != null) { 
            Integer[] buy_trade = m1.get(buy_key);
            buy_pnl = m2.get(instrument_id) - buy_trade[1] < 0 ? m2.get(instrument_id) - buy_trade[1] : 0;
        }

        if(sell_pnl == 0 && buy_pnl == 0) { 
            return "No Bad Trade";
        }

        String bad_key = sell_pnl < buy_pnl ? sell_key : buy_key;

        int worst_trade_id = m1.get(bad_key)[0];

        return Integer.toString(worst_trade_id);

    }

    public void handleStdIn() {
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()) {
            String line = in.nextLine();
            String[] tokens = line.split(" ");
            if(tokens[0].equals("PRICE")) {
                this.process_price_update(tokens[1], Integer.parseInt(tokens[2]));
            }
            else if(tokens[0].equals("TRADE")) {
                this.process_trade(Integer.parseInt(tokens[1]), tokens[2], tokens[3], Integer.parseInt(tokens[4]), Integer.parseInt(tokens[5]));
            }
            else if(tokens[0].equals("WORST_TRADE")) {
                String instrument_id = tokens[1];
                String output = this.output_worst_trade(instrument_id);
                System.out.println(output);
            }

        }
        in.close();
    }
    
}
