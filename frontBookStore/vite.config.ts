import { defineConfig } from 'vitest/config'
import react from '@vitejs/plugin-react'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [react()],
  server: {
    port: 3000
  },
  test: {
    globals: true,
    environment: 'happy-dom',
    alias: [
      {
        find: /.*\.(?:css)$/,
        replacement: 'identity-obj-proxy'
      }
    ],
    css: {
      include: /.*/
    },
    deps: {
      web: {
        transformCss: true
      }
    }
  }
})
